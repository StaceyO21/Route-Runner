package org.launchcode.route_runner.WebConfig.java;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler("/uploads/images/**")
                .addResourceLocations("file:///C;/Users/stace/Documents/Route-Runner/Route-Runner/uploads/images/");
    }
}
