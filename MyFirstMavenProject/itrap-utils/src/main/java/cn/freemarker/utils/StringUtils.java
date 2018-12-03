package cn.freemarker.utils;

/**
 * Created by zezhong.shang on 17-6-2.
 */
public class StringUtils {

    /**
     * 某位置字母大写，为其他方法作辅助作用
     * @param name
     * @param indx
     * @return
     */
    public static String captureName(String name, int indx) {
        name = name.substring(0, indx) + name.substring(indx, indx + 1).toUpperCase() + name.substring(indx + 1);
        return name;
    }

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }

    /***
     * 首字母小写
     * @param name
     * @return
     */
    public static String lowerName(String name) {
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
        return name;
    }

    /***
     * 去掉下划线 并用驼峰原则进行转化
     * @return
     */
    public static String putOffUnderline(String columnName) {
        StringBuffer fieldNameBuffer = null;
        String tempNameArray[] = columnName.split("_");
        for (int i = 0; i < tempNameArray.length; i++) {
            if (i == 0) {
                fieldNameBuffer = new StringBuffer(tempNameArray[i]);
            } else {
                fieldNameBuffer.append(captureName(tempNameArray[i]));
            }
        }
        return fieldNameBuffer.toString();
    }

    public static void main(String[] args) {
        String a = captureName("a_bccc_d",7);
        System.out.println(a);
    }
}
