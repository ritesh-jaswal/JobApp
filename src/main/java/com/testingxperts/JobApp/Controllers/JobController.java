package com.testingxperts.JobApp.Controllers;

import com.testingxperts.JobApp.Models.Job;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController
{
    private List<Job> jobs = new ArrayList<>();

    @GetMapping
    public List<Job> findAll()
    {
        return jobs;
    }

    @PostMapping
    public String createJob(@RequestBody Job job)
    {
        jobs.add(job);

        return "Job Added Successfully";
    }
}
