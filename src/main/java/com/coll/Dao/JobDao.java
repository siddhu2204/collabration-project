package com.coll.Dao;

import java.util.List;

import com.coll.model.Job;

public interface JobDao
{
public boolean publishJob(Job job);
public boolean deleteJob(Job job);
public List<Job>showjobs();
public Job getJob(int jobid);
}
