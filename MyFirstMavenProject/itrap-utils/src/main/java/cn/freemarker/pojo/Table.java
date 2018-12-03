package cn.freemarker.pojo;

import cn.freemarker.utils.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/12.
 */
public class Table implements Serializable {

    private String tableName;

    private String comment;

    private List<Cloumn> cloumns;

    private String className;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Cloumn> getCloumns() {
        return cloumns;
    }

    public void setCloumns(List<Cloumn> cloumns) {
        this.cloumns = cloumns;
    }

    //自定义方法：获取类名（首字母大写，去掉下划线）
    public String getClassName(){
      return  StringUtils.captureName(StringUtils.putOffUnderline(this.tableName));
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
