package ru.dglv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("ru.dglv")
@ImportResource("classpath:/spring/spring-context.xml")
public class SpringBootWebAppConfig extends WebMvcConfigurerAdapter
{

}
