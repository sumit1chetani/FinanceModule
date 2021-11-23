package com.dci.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.dci.SessionTimeoutInterceptor;
import com.dci.common.util.ConfigurationProps;
import com.dci.web.MultiTenancyInterceptor;
import com.dci.web.auth.UserAuthenticationResolver;



@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Value("${folder.path.localPath}")
	private String localPath;

	@Value("${file.upload.absolutePath}")
	private String getFilePropertyUrl;

	@Value("${file.upload.serverPath}")
	private String getFileServerPath;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MultiTenancyInterceptor());
		registry.addInterceptor(new SessionTimeoutInterceptor());
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imgFiles/**").addResourceLocations(
				"file:" + localPath);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
		registry.addResourceHandler("/"+getFileServerPath+"/**").addResourceLocations("file:///"+getFilePropertyUrl+"/");
		registry.addResourceHandler("/filePath/**").addResourceLocations("file:///"+ConfigurationProps.exportFilesPath+"/");
		/*registry.addResourceHandler("/athenaHelpvideos/*").addResourceLocations("file:///"+ConfigurationProps.athenaHelpVideosPath+"/");
		registry.addResourceHandler("/uniconHelpvideos/*").addResourceLocations("file:///"+ConfigurationProps.uniconHelpVideosPath+"/");*/
		registry.addResourceHandler("/athenaHelpVideos/*").addResourceLocations("/athenaHelpVideos/");
		registry.addResourceHandler("/uniconHelpVideos/*").addResourceLocations("/uvniconHelpVideos/");
		
	}
	
	/*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("views/**", "/views/**");
    }*/

	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new UserAuthenticationResolver());
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/views/");
		resolver.setSuffix(".jsp");
		/*resolver.setViewClass(JstlView.class);*/
		registry.viewResolver(resolver);
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	

}
