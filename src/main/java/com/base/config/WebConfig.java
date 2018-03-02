package com.base.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.base.model.Example;




@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.base" })
public class WebConfig extends WebMvcConfigurerAdapter {

   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
   
   
   @Bean
   public Example example() {
   	Example ex = new Example();
   	ex.setId("2");
       return ex;
   }
   
   
   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
   }
   
   
//   @Bean
//   public LocalValidatorFactoryBean validator() {
//       LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//       bean.setValidationMessageSource(messageSource());
//       return bean;
//   }

//   @Override
//   public Validator getValidator() {
//       return validator();
//   }

}
