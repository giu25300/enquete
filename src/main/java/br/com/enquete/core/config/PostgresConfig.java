package br.com.enquete.core.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.NonNull;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "postgresEntityManagerFactory", 
    transactionManagerRef = "postgresTransactionManager",
    basePackages = "br.com.enquete.dominio.repositorio")
public class PostgresConfig {
  private Environment env;

  @Autowired
  public PostgresConfig(Environment env) {
    this.env = env;
  }
  
  @Bean
  @ConfigurationProperties(prefix = "datasource.enquete")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();    
  }
  

  @Bean(name = "postgresEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
    final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPersistenceUnitName("postgres");
    em.setPackagesToScan("br.com.enquete.dominio.entidade");    
    em.setPersistenceProvider(new HibernatePersistenceProvider());

    HibernateJpaVendorAdapter a = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(a);

    em.setJpaProperties(hibernateProperties());
    return em;
  }

  @Bean(name = "postgresTransactionManager")
  public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactory") EntityManagerFactory postgresEntityManagerFactory) {
    return new JpaTransactionManager(postgresEntityManagerFactory);
  }

  @NonNull
  private Properties hibernateProperties() {
    Properties props = new Properties();
    props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    return props;
  }
}