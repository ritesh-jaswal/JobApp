package com.testingxperts.JobApp.ServiceImpls;

import com.testingxperts.JobApp.Models.Job;
import com.testingxperts.JobApp.Services.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService
{
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll()
    {
        return jobs;
    }

    @Override
    public void createJob(Job job)
    {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id)
    {
        for(Job job : jobs)
        {
            if(job.getId().equals(id))
            {
                return job;
            }
        }
        return null;
    }
}
