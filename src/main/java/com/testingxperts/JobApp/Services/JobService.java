package com.testingxperts.JobApp.Services;

import com.testingxperts.JobApp.Models.Job;

import java.util.List;

public interface JobService
{
    List<Job> findAll();
    void createJob(Job job);
}
