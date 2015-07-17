package gamesStore.config;

import gamesStore.dao.GameDao;
import gamesStore.dao.GameDaoImp;
import gamesStore.dao.GamerDao;
import gamesStore.dao.GamerDaoImp;
import gamesStore.model.Game;
import gamesStore.model.Gamer;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@EnableWebMvc
@ComponentScan("gamesStore")
@EnableTransactionManagement
@Configuration
public class ApplicationContextConfig extends WebMvcConfigurerAdapter
{
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean(name = "dataSource")
    public DataSource getDataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();

//        dataSource.setUrl("jdbc:mysql://localhost:3306/gameStore");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/GamesStore");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("user");
        dataSource.setPassword("123");
        return dataSource;
    }


    private Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        // properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        properties.put("hibernate.hbm2ddl.auto", "update");

        return properties;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource)
    {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClasses(Gamer.class);
        sessionBuilder.addAnnotatedClasses(Game.class);
        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory)
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);

        return transactionManager;
    }

    @Autowired
    @Bean(name = "gamerDao")
    public GamerDao getGamerDao(SessionFactory sessionFactory)
    {
        return new GamerDaoImp(sessionFactory);
    }

    @Autowired
    @Bean(name = "gameDao")
    public GameDao getGameDao(SessionFactory sessionFactory)
    {
        return new GameDaoImp(sessionFactory);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }
}
