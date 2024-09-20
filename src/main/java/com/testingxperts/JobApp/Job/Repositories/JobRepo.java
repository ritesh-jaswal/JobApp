package com.testingxperts.JobApp.Job.Repositories;

import com.testingxperts.JobApp.Job.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job,Long> {
}
