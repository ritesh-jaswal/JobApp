package com.testingxperts.JobApp.Controllers;

import com.testingxperts.JobApp.Models.Job;
import com.testingxperts.JobApp.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController
{
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> findAll()
    {
        return jobService.findAll();
    }

    @PostMapping
    public String createJob(@RequestBody Job job)
    {
        jobService.createJob(job);

        return "Job Added Successfully";
    }
}
