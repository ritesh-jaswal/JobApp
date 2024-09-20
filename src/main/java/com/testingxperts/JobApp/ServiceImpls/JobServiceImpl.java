package com.testingxperts.JobApp.ServiceImpls;

import com.testingxperts.JobApp.Models.Job;
import com.testingxperts.JobApp.Services.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public boolean deleteJob(Long id)
    {
        Iterator<Job> iterator = jobs.iterator();

        while (iterator.hasNext())
        {
            Job job = iterator.next();

            if(job.getId().equals(id))
            {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job job)
    {
        for (Job j:jobs)
        {
            if(j.getId().equals(id))
            {
                j.setTitle(job.getTitle());
                j.setDescription(job.getDescription());
                j.setMinSalary(job.getMinSalary());
                j.setMaxSalary(job.getMaxSalary());
                j.setLocation(job.getLocation());

                return true;
            }
        }
        return false;
    }
}
