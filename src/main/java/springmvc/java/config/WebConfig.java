package springmvc.java.config;


import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by oleg on 16.10.2016.
 */


@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"springmvc.java"})
@Import({springmvc.java.config.ApplicationContext.class})
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter {
    public void addViewControllers(ViewControllerRegistry registry) {
        //добавляем мапинг для Views
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/newBook.html").setViewName("newBook");
        registry.addViewController("/bookBy.html").setViewName("bookBy");
        registry.addViewController("/about.html").setViewName("about");

    }


    @Bean
    public InternalResourceViewResolver internalResourceViewResolver () {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

        internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }


    @Override
    public void addResourceHandlers  (ResourceHandlerRegistry registry) {
        registry.addResourceHandler("resources/**").addResourceLocations("/resources/");
    }
    @Bean //для подключения БД - импорт проперти из файла
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer () {
        return new PropertySourcesPlaceholderConfigurer ();
    }


}