package yncrea.lab04.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import yncrea.lab04.core.config.AppConfig;
import yncrea.lab04.core.config.DBConfig;
import yncrea.lab04.web.config.WebConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public  Class<?>[] getRootConfigClasses(){
        return new  Class<?>[]{AppConfig.class, DBConfig.class};
    }

    public Class<?>[] getServletConfigClasses(){
            return new Class<?>[]{WebConfig.class};
    }

    public String[] getServletMappings(){
        return new String[]{"/"};
    }
}
