package com.testingxperts.JobApp.Services;

import com.testingxperts.JobApp.Models.Job;

import java.util.List;

public interface JobService
{
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean deleteJob(Long id);
    boolean updateJobById(Long id, Job job);
}
