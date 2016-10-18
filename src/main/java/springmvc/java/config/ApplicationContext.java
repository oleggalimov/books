package springmvc.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springmvc.java.bookservices.bookservice;
import springmvc.java.bookservices.bookserviceImpl.bookserviceImpl;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by oleg on 16.10.2016.
 */
@Configuration
@EnableJpaRepositories (basePackages = {"springmvc.java.DAO"})
@EnableTransactionManagement
public class ApplicationContext {

    @Autowired
    private Environment environment;

    @Bean
    public JpaTransactionManager transactionManager (EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager ();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        DatabasePopulatorUtils.execute(databasePopulator(),dataSource());
        return jpaTransactionManager;
    }

    @Bean
    public DataSource dataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter () {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter ();

        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setShowSql(true);


        return jpaVendorAdapter;
    }

    @Bean

    public LocalContainerEntityManagerFactoryBean entityManagerFactory () {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean ();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("springmvc.java.domain");
        Properties jpaproperties = new Properties();
        jpaproperties.setProperty("hibernate.hbm2ddl.auto","create-drop");
        entityManagerFactory.setJpaProperties(jpaproperties);
        return entityManagerFactory;

    }

    DatabasePopulator databasePopulator () {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.setContinueOnError(true);
        resourceDatabasePopulator.addScript(new ClassPathResource("insertSomeValues.sql"));
        return resourceDatabasePopulator;
    }


    @Bean
    public bookservice blogPostService () {
        return new bookserviceImpl();
    }

}
