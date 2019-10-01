package com.apjschool.librarymgmt.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.apjschool.librarymgmt.util.InterceptorExample;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.apjschool.librarymgmt")
//@AnnotationDrivenConfig
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public CookieLocaleResolver cookie() {
    	CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    	localeResolver.setDefaultLocale(Locale.ENGLISH);
    	return localeResolver;
    }
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    	messageSource.setBasename("classpath:messages");
    	//messageSource.setCacheSeconds(5);
    	return messageSource;
    }
    
    /*configuration to add interceptor start*/    
   /* public InterceptorExample interceptorExample() {
    	InterceptorExample interceptorExample = new InterceptorExample();
    	return interceptorExample;
    }*/
    
    @Autowired
    InterceptorExample interceptorExample;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptorExample);
		registry.addInterceptor(getLocaleChangeInterceptor());
		//registry.addInterceptor(getThemeChangeInterceptor());
	}
	/*configuration to add interceptor end*/ 
	
	/*configuration for i18n start*/
	@Bean
	public LocaleChangeInterceptor getLocaleChangeInterceptor() {
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("siteLanguage");
		return changeInterceptor;
	}
	
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		localeResolver.setCookieName("localeCookie");
		localeResolver.setCookieMaxAge(3600);
		return localeResolver;
	}
	/*configuration for i18n end*/
	
	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver mappingExceptionResolver = new SimpleMappingExceptionResolver();
		Properties exceptionMapping = new Properties();
		//Set the exception-view mapping
		exceptionMapping.setProperty("IOException", "ExceptionPage");
		mappingExceptionResolver.setExceptionMappings(exceptionMapping);
		/*
		 * Set the default exception page. Spring will redirect to this page if there is
		 * no exception handler of the exception thrown.
		 */
		mappingExceptionResolver.setDefaultErrorView("ExceptionPage");
		//To log exception on the console
		mappingExceptionResolver.setWarnLogCategory("MVCLogger");
		return mappingExceptionResolver;
	}
	
	/*configuration for theme start*/
	/*@Bean
	public ResourceBundleThemeSource getResourceBundleThemeSource() {
		ResourceBundleThemeSource resourceBundleThemeSource = new ResourceBundleThemeSource();
		resourceBundleThemeSource.setBasenamePrefix("classpath:theme-");
		return resourceBundleThemeSource;
	}
	
	@Bean
	public CookieThemeResolver getCookieThemeResolver() {
		CookieThemeResolver cookieThemeResolver = new CookieThemeResolver();
		cookieThemeResolver.setDefaultThemeName("orange");
		return cookieThemeResolver;
	}
	
	@Bean
	public ThemeChangeInterceptor getThemeChangeInterceptor() {
		ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
		themeChangeInterceptor.setParamName("siteTheme");
		return themeChangeInterceptor;
	}*/
	/*configuration for theme end*/
	
	
}
