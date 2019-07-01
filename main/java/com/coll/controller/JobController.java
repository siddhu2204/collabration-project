package com.coll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.Dao.JobDao;
import com.coll.model.Blog;
import com.coll.model.Forum;
import com.coll.model.Job;

@RestController
public class JobController 
{
@Autowired
JobDao jobDao;

@GetMapping("/showAllJobs")
public ResponseEntity<List<Job>>showAllJobs()
{

	List<Job>listjobs=jobDao.showjobs();
	
	if(listjobs.size()>0)
	{
		return new ResponseEntity<List<Job>>(listjobs,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<Job>>(listjobs,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
@GetMapping("/getJob/{jobid}")
public ResponseEntity<Job>getJob(@PathVariable("jobid")int jobid)
{
	Job job=(Job)jobDao.getJob(jobid);
	return new ResponseEntity<Job>(job,HttpStatus.OK);
	
}

@DeleteMapping("/deleteJob/{jobid}")
public ResponseEntity<Job> deleteJob(@PathVariable("jobid") int jobid)
{
    System.out.println("Fetching & Deleting job with id " + jobid);

    Job job=jobDao.getJob(jobid);
 
    if (job == null) 
    {
       System.out.println("Unable to delete job with id " + jobid + " not found");
        return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
    }
    else
    {

    	jobDao.deleteJob(job);
    return new ResponseEntity<Job>(HttpStatus.OK);
}
}
@PostMapping(value="/publishJob", produces=MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> publishJob(@RequestBody Job job)
{
	//job.setCompanyName("FlowServe");
	//job.setLastDatetoApply(new java.util.Date());
	//job.setCTC(60000);
	if(jobDao.publishJob(job))
	{
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	else
	{
		return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}



