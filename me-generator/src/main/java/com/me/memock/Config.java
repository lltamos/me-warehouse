package com.me.memock;

/**
 * @author Erwin Feng
 * @since 2019-04-17 12:04
 */
public class Config {

    /** 包名：controller */
    public static final String PACKAGE_NAME_CONTROLLER = "controller";

    /** 包名：service */
    public static final String PACKAGE_NAME_SERVICE = "repository";

    /** 包名：service.impl */
    public static final String PACKAGE_NAME_SERVICE_IMPL = "repository.impl";

    /** 包名：model */
    public static final String PACKAGE_NAME_MODEL = "dataobject";

    /** 包名：dao */
    public static final String PACKAGE_NAME_DAO = "mapper";

    /** 目录名：xml */
    public static final String DIR_NAME_XML = "mappers";

    /** 文件名后缀：Model */
    public static final String FILE_NAME_MODEL = "%s";

    /** 文件名后缀：Dao */
    public static final String FILE_NAME_DAO = "I%sMapper";

    /** 文件名后缀：Mapper */
    public static final String FILE_NAME_XML = "%sMapper";

    /** MP开头，Service结尾 */
    public static final String FILE_NAME_SERVICE = "%sService";

    /** 文件名后缀：ServiceImpl */
    public static final String FILE_NAME_SERVICE_IMPL = "%sServiceImpl";

    /** 文件名后缀：Controller */
    public static final String FILE_NAME_CONTROLLER = "%sController";

    /** 逻辑删除字段 */
    public static final String FIELD_LOGIC_DELETE_NAME = "delete_status";


    /** 乐观锁字段名 */
    public static final String FIELD_VERSION_NAME = "version";

    /** 作者 */
    public static final String AUTHOR = "Erwin Feng";

    /** 生成文件的输出目录 */
    public static String PROJECT_PATH = System.getProperty("user.dir");

    /** 输出目录 */
    public static final String OUTPUT_DIR = PROJECT_PATH + "/me-generator/temp/code-generator";

    /** 模板引擎。velocity / freemarker / beetl */
    public static final String TEMPLATE_ENGINE = "velocity";

    /** 是否支持Swagger，默认不支持 */
    public static final Boolean SWAGGER_SUPPORT = false;

}
