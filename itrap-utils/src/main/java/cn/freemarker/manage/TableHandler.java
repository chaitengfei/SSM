package cn.freemarker.manage;

import cn.freemarker.pojo.Table;
import cn.freemarker.pojo.Cloumn;
import cn.freemarker.utils.PropertiesUtils;


import java.sql.*;
import java.util.*;

/**
 * Created by zezhong.shang on 17-6-5.
 */
public class TableHandler {

    private List<String> tableExceptList = new ArrayList<String>();

    private static String DBDRIVER = PropertiesUtils.get("database.properties", "driver");

    private static String DBURL = PropertiesUtils.get("database.properties", "url");

    private static String DBUSER = PropertiesUtils.get("database.properties", "user");

    private static String DBPASS = PropertiesUtils.get("database.properties", "password");

    public void addExceptTable(String tableName) {
        tableExceptList.add(tableName);
    }

    //查询数据库中的所有表及字段信息
    private List<Table> queryDataTables() {
        DatabaseMetaData dmd = null;
        Connection conn = null;
        //每个数据库中有多个表，List来存储
        List<Table> tables = new ArrayList<Table>();
        try {
            //1、获取数据库的连接
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            //2、获取metaData
            DatabaseMetaData dbmd = conn.getMetaData();
            //3、获取数据库所有表信息（固定写法）
            ResultSet resultSet = dbmd.getTables(null, null, null, new String[]{"TABLE"});
            //4、遍历结果集
            while (resultSet.next()) {
                //获取表名（固定写法）
                String tableName = resultSet.getString("TABLE_NAME");
                //获取表注解（固定写法）
                String remarkes = getCommentByTableName(tableName);
                System.out.println("获取表名："+tableName);

                Table table = new Table();
                table.setTableName(tableName);
                table.setComment(remarkes);
                table.setCloumns(new ArrayList<Cloumn>());

                //获取表中所有列信息（需要传入参数表名，其他固定写法）
                ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
                //遍历结果集
                while (rs.next()) {
                    Cloumn cloumn = new Cloumn();

                    //获取列名称
                    cloumn.setCloumnName(rs.getString("COLUMN_NAME"));
                    //获取列类型
                    cloumn.setCloumnType(rs.getString("TYPE_NAME"));
                    //获取列注释
                    cloumn.setComment(rs.getString("REMARKS"));

                    //把每个列的列对象加入到table的List<Cloumn>中
                    table.getCloumns().add(cloumn);
                }
                //把每个table对象加入到List集合中
                tables.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tables;
    }

    public List<Table> getTables() {


        List<Table> dataTableList = queryDataTables();


        if (null != dataTableList && dataTableList.size() != 0) {
            if (null != tableExceptList && tableExceptList.size() == 0) {
                for (String tableName : tableExceptList) {
                    Iterator<Table> it = dataTableList.iterator();
                    while (it.hasNext()) {
                        Table x = it.next();
                        if (x.getTableName().equals(tableName)) {
                            it.remove();
                        }
                    }
                }
            }
        }
        return dataTableList;
    }

    private static String getCommentByTableName(String tableName) throws Exception {
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + tableName);
        String comment = null;
        if (rs != null && rs.next()) {
            comment = parse(rs.getString(2));
        }
        rs.close();
        stmt.close();
        conn.close();
        return comment;
    }

    /**
     * 返回注释信息
     *
     * @param all
     * @return
     */
    private static String parse(String all) {
        String comment = null;
        int index = all.indexOf("COMMENT='");
        if (index < 0) {
            return "";
        }
        comment = all.substring(index + 9);
        comment = comment.substring(0, comment.length() - 1);
        return comment;
    }
}
