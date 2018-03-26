package cn.s_c.util;

public class PathUtil {
    public final static String TEMP_FILE_NAME = "s_c";

    public static String getTmpPath() {
        java.util.Properties properties = System.getProperties();
        String tempFileName = properties.getProperty("java.io.tmpdir");
        return tempFileName + TEMP_FILE_NAME;
    }
}
