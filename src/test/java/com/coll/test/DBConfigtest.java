package com.coll.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DBConfig.DBConfig;

public class DBConfigtest
{
@BeforeClass

public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
	context.scan("com.coll");
	//context.refresh();
	
}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
