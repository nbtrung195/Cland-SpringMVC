package cland.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration // cơ chế DI IOC
@ComponentScans({ @ComponentScan(value = "cland.*") })
public class AppConfig {
	
	@Bean(name = "viewResolver")
	public ViewResolver getViewResolver() {
	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
	// TilesView 3
	viewResolver.setViewClass(TilesView.class);
	return viewResolver;
	}
	
	@Bean(name = "ViewResolver") // viewResolver
	public InternalResourceViewResolver GetViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/views/admin/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean(name = "tilesConfigurer")
	public TilesConfigurer getTilesConfigurer() {
	TilesConfigurer tilesConfigurer = new TilesConfigurer();
	// TilesView 3
	tilesConfigurer.setDefinitions("/WEB-INF/tiles/PublicTiles.xml","/WEB-INF/tiles/AdminTiles.xml");
	return tilesConfigurer;
	}
	
	@Bean(name = "multipartResolver") // upload file
	public MultipartResolver getMultipartResolver() {
		CommonsMultipartResolver resover = new CommonsMultipartResolver();
		// 1MB
		
		return resover;
	}
	
	@Bean(name = "messageSource") // get messages
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages/validate");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
}
