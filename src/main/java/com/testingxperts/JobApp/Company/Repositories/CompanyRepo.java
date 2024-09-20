package com.testingxperts.JobApp.Company.Repositories;

import com.testingxperts.JobApp.Company.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
}
