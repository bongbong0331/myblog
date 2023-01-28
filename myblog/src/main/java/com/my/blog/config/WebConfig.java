package com.my.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/myblogimg/**")
		.addResourceLocations("file:///" + "C:\\myblog\\myblogimg\\headline\\")
		.setCachePeriod(60 * 10 * 6)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
	}
}
