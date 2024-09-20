package com.testingxperts.JobApp.Job.Repositories;

import com.testingxperts.JobApp.Job.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job,Long> {
}
