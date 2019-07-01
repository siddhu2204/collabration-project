package com.coll.config;

import java.io.File;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.coll.DBConfig.DBConfig;


public class HelloIntializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	
	
	protected void customizeRegistration(ServletRegistration.Dynamic registration)
	{
		System.out.println("Customize Registration");
		registration.setInitParameter("dispatchOptionsRequest", "true");
		registration.setAsyncSupported(true);
	}
	    @Override
	    protected Class<?>[] getRootConfigClasses() 
	    {
	    	System.out.println("get rootconfig class");
	        return new Class[] { HelloConfiguration.class,DBConfig.class};
	    }
	   
	    @Override
	    protected Class<?>[] getServletConfigClasses() 
	    {
	     System.out.println("get servlet.class");
	    	return null;
	    }
	   
	    @Override
	    protected String[] getServletMappings() 
	    {
	    	System.out.println("get mapping class");
	        return new String[] { "/" };
	
	    }
	     
	    protected Filter[] getFilters()
		{
			CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
			encodingFilter.setEncoding(StandardCharsets.UTF_8.name());
			return new Filter[] {encodingFilter};
		

	    }
	    }
	  
	

