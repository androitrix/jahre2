package nz.co.jahre2.config;

import nz.co.jahre2.config.servlet.ServletContextConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
*
* Replacement for most of the content of web.xml, sets up the root and the servlet context config.
*
*/
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
       return null;
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
       return new Class<?>[] {ServletContextConfig.class};
   }

   @Override
   protected String[] getServletMappings() {
       return new String[]{"/"};
   }




}