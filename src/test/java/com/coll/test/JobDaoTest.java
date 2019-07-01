package com.coll.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DBConfig.DBConfig;
import com.coll.Dao.JobDao;
import com.coll.model.Job;


public class JobDaoTest
{
static JobDao jobDao;
@BeforeClass
public static void executefirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
	context.scan("com.coll");
	
	jobDao=(JobDao)context.getBean("jobDao");
	
}

	
	@Test
	public void publishJobtest()
	{
		Job job=new Job();
		job.setJobdesignation("General Manager");
		job.setCompanyname("Rialto Enterprises");
		job.setCtc(50000);
		job.setLocation("Chennai");
		job.setSkills("finance");
		job.setLastdatetoapply(new Date());
		assertTrue(jobDao.publishJob(job));	
	}
	@Ignore
	@Test
	public void deleteJobtest()
	{
		Job job=jobDao.getJob(0);
		assertTrue(jobDao.deleteJob(job));
	}
	@Ignore
	@Test
	public void showJobstest()
	{
		List<Job>joblist=jobDao.showjobs();
		assertTrue(joblist.size()>0);
		for(Job job:joblist)
		{
			System.out.println(job.getJobid());
			System.out.println(job.getCompanyname());
			System.out.println(job.getJobdesignation());
			
		}
		
	}
}
