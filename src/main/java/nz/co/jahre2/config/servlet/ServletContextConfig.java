package nz.co.jahre2.config.servlet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"nz.co.jahre2.controller"})
public class ServletContextConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
	}
	
	@Bean 
	ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
 
        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
 
        resolvers.add(thymeLeafViewResolver());
        resolvers.add(jsonViewResolver());
         
        resolver.setViewResolvers(resolvers);
        return resolver;
    } 

	@Bean ViewResolver jsonViewResolver() {
		// TODO Auto-generated method stub
		return new JsonViewResolver();
	}

	@Bean TemplateResolver templateResolver() {
		
		ServletContextTemplateResolver tr = new ServletContextTemplateResolver();
		tr.setPrefix("/WEB-INF/templates/");
		tr.setSuffix(".html");
		tr.setTemplateMode("HTML5");
		return tr;
	}
	
	@Bean SpringTemplateEngine springtemplateEngine() {
		SpringTemplateEngine ste = new SpringTemplateEngine();
		ste.setTemplateResolver(templateResolver());
		return ste;
	}
	
    @Bean ViewResolver thymeLeafViewResolver() {
    	ThymeleafViewResolver v = new ThymeleafViewResolver();
        v.setTemplateEngine(springtemplateEngine());
        v.setOrder(1);
        return v;
    }
}
