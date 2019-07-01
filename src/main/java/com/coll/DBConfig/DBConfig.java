package com.coll.DBConfig;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Forum;
import com.coll.model.ForumComment;
import com.coll.model.Friend;
import com.coll.model.Job;
import com.coll.model.ProfilePicture;
import com.coll.model.UserDetail;


@Configuration
@ComponentScan("com.coll")
@EnableTransactionManagement
public class DBConfig 
{
	//data source
@Bean(name="datasource")
public DataSource getDataSource()
{
	DriverManagerDataSource db=new DriverManagerDataSource();
	db.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	db.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	db.setUsername("hr");
	db.setPassword("oracle");
	System.out.println("========Datasource created===========");
	return db;	
}



@Bean(name="sessionFactory")

public SessionFactory getSessionFactory()
{
	Properties prop=new Properties();
	prop.put("hibernate.hbmddl2.auto", "update");
	prop.put("hibernate.dialect.dialect","org.hibernate.dialect.Oracle11gdialect");
	prop.put("hibernate.showsql","true");
	LocalSessionFactoryBuilder lb=new LocalSessionFactoryBuilder(this.getDataSource());
	lb.addProperties(prop);
	lb.addAnnotatedClass(Blog.class);
	lb.addAnnotatedClass(BlogComment.class);
	lb.addAnnotatedClasses(UserDetail.class);
	lb.addAnnotatedClass(Job.class);
	lb.addAnnotatedClass(Forum.class);
	lb.addAnnotatedClass(Friend.class);
	lb.addAnnotatedClass(ProfilePicture.class);
	lb.addAnnotatedClass(ForumComment.class); 
	SessionFactory sessionfactory=lb.buildSessionFactory();
	System.out.println("=========sessionfactory created==========");
	return sessionfactory;
	
	
}




@Bean(name="trancationalManager")

public HibernateTransactionManager getTranscationManager(SessionFactory sessionfactory)
{
	System.out.println("=============transcationfactory created==========");
	return new  HibernateTransactionManager(sessionfactory);
	
}

}
