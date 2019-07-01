package com.coll.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Job;


@Repository("jobDao")
@Transactional

public class JobDaoImpl implements JobDao
{
@Autowired
SessionFactory sessionfactory;
	@Override
	public boolean publishJob(Job job)
	{
		try
		{
			sessionfactory.getCurrentSession().save(job);
		
		
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
	}

	@Override
	public boolean deleteJob(Job job) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public List<Job> showjobs()
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job>listjobs=query.list();
		session.close();
		return listjobs ;
	}

	@Override
	public Job getJob(int jobid) 
	{
		Session session=sessionfactory.openSession();
		Job job=session.get(Job.class, jobid);
		session.close();
		return job ;
	}

}
