package com.testingxperts.JobApp.Controllers;

import com.testingxperts.JobApp.Models.Job;
import com.testingxperts.JobApp.Services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController
{
    private JobService jobService;

    public JobController(JobService jobService)
    {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll()
    {
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {
        Job job = jobService.getJobById(id);

        if(job != null)
        {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
        jobService.createJob(job);

        return new ResponseEntity<>("Job Added Successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id)
    {
        boolean job=jobService.deleteJob(id);
        if(job)
        {
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
