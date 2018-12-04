package cn.freemarker.pojo;

import cn.freemarker.utils.TypeConstant;
import cn.freemarker.utils.StringUtils;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/12.
 */
public class Cloumn {

    private String cloumnName;//列名
    private String comment;//列注释
    private String cloumnType;//列类型

    private String javaType;
    private String fieldName;
    private String upperCasecloumnName;


    public String getCloumnName() {
        return cloumnName;
    }

    public void setCloumnName(String cloumnName) {
        this.cloumnName = cloumnName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCloumnType() {
        return cloumnType;
    }

    public void setCloumnType(String cloumnType) {
        this.cloumnType = cloumnType;
    }

    //自定义方法，获取列明（去掉下划线 并用驼峰原则进行转化）
    public String getFieldName() {
        return StringUtils.putOffUnderline(this.cloumnName);
    }

    //自定义方法，获取列类型（根据数据库类型，获取Java类型）
    public String getJavaType() {
        return TypeConstant.getJavaType(this.cloumnType);
    }

    //自定义方法：获取列名称（首字母大写的列名，去掉下划线 并用驼峰原则进行转化）
    public String getUpperCasecloumnName(){
        return StringUtils.captureName(getFieldName());
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setUpperCasecloumnName(String upperCasecloumnName) {
        this.upperCasecloumnName = upperCasecloumnName;
    }
}
