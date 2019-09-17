package com.windcloud.windtool;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * file:CodeGeneratorUtil.java
 * created by Fanghonghui on 2019/7/18
 * email:a6551142@163.com
 */
public class CodeGeneratorUtil {
    private final static String[] TABLES = {"sys_user","sys_department","sys_menu","sys_role"}; //表名
    private final static String MODULE_NAME = "";
    private final static String ENTITY_OUT_PATH = "wind-upms/wind-upms-api";
    private final static String ENTITY_PACKAGE = "com.windcloud.windupmsapi.entity";
    private final static String SERVICE_OUT_PATH = "wind-upms/wind-upms-biz";
    private final static String SERVICE_PACKAGE = "com.windcloud.windupmsbiz";


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(SERVICE_OUT_PATH + "/src/main/java");
        gc.setAuthor("fanghh");
        gc.setOpen(false);
        gc.setActiveRecord(true);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/wind?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setModuleName(MODULE_NAME);
        pc.setEntity(ENTITY_PACKAGE);
        pc.setController(SERVICE_PACKAGE + ".controller");
        pc.setService(SERVICE_PACKAGE + ".service");
        pc.setServiceImpl(SERVICE_PACKAGE + ".service.impl");
        pc.setMapper(SERVICE_PACKAGE + ".mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String entityTemplatePath = "/templates/entity.java.vm";
        String controllerTemplatePath = "/templates/controller.java.vm";
        String serivceTemplatePath = "/templates/service.java.vm";
        String serviceImplTemplatePath = "/templates/serviceImpl.java.vm";
        String mapperTemplatePath = "/templates/mapper.java.vm";
        String mapperXmlTemplatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(entityTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return ENTITY_OUT_PATH + "/src/main/java/"
                        + ENTITY_PACKAGE.replace("." , "/")
                        + "/" + pc.getModuleName()
                        + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });

        focList.add(new FileOutConfig(controllerTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_OUT_PATH + "/src/main/java/"
                        + SERVICE_PACKAGE.replace("." , "/")
                        + "/controller/" + pc.getModuleName()
                        + tableInfo.getControllerName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(serivceTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_OUT_PATH + "/src/main/java/"
                        + SERVICE_PACKAGE.replace("." , "/")
                        + "/service/" + pc.getModuleName()
                        + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(serviceImplTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_OUT_PATH + "/src/main/java/"
                        + SERVICE_PACKAGE.replace("." , "/")
                        + "/service/impl/" + pc.getModuleName()
                        + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(mapperTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_OUT_PATH + "/src/main/java/"
                        + SERVICE_PACKAGE.replace("." , "/")
                        + "/mapper/" + pc.getModuleName()
                        + tableInfo.getMapperName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(mapperXmlTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_OUT_PATH + "/src/main/resources/mapper"
                        + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + StringPool.DOT_XML;
            }
        });

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        templateConfig.setService(null);
        templateConfig.setController(null);
        templateConfig.setXml(null);
        templateConfig.setEntity(null);
        templateConfig.setMapper(null);
        templateConfig.setServiceImpl(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setLogicDeleteFieldName("del");


        // 公共父类
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
//        strategy.setColumnNaming(NamingStrategy.valueOf("id"));
        strategy.setInclude(TABLES);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }
}
