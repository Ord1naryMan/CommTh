package com.thingy.commth.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final String jsCookieVersion;

    public WebConfiguration(@Value("${js-cookie.version}")String jsCookieVersion) {
        this.jsCookieVersion = jsCookieVersion;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/js-cookie/**")
                .addResourceLocations("classpath:META-INF/resources/webjars/js-cookie/" +
                        jsCookieVersion
                        + "/dist/");
    }

}