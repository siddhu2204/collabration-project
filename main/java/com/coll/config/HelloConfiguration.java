package com.coll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = "controller,com.coll")
	public class HelloConfiguration extends WebMvcConfigurerAdapter{
	     
	    @Override
	    public void configureViewResolvers(ViewResolverRegistry registry)
	    {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        registry.viewResolver(viewResolver);
	    
	    }
	    
	    @Bean(name="filterMultipartResolver")
	    public CommonsMultipartResolver getMultipartResolver()
	    {
	    	CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    	resolver.setMaxUploadSize(1000000);
	    	System.out.println("i am in image controller");
	    	
	    	return resolver;
	    	
	    }
	    
	 
	    /*@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	    }*/
	 
	}

