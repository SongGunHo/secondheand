package org.koreait.globle.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

public class MessageSourceConfig {

    @Bean
    public MessageSourceConfig messageSourceConfig(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.addBasenames("message.common", "message.validators" ,"message.errors");

        ms.setDefaultEncoding("UTF-8");
        ms.setUseCodeAsDefaultMessage(true);
        return ms;
    }





}
