package yncrea.lab04.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import yncrea.lab04.core.config.AppConfig;
import yncrea.lab04.core.config.DBConfig;
import yncrea.lab04.web.config.WebConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    private AppConfig appConfig;
    private DBConfig dbConfig;
    private WebConfig webConfig;

    public  Class<Object>[] getRootConfigClasses(){
        return new  Class<Object>[]{appConfig, dbConfig};
    }

    public Class<?>[] getServletConfigClasses(){
        return new Class<?>[]{webConfig};
    }

    public String[] getServletMappings(){
        return new String[]{"/"};
    }
}
