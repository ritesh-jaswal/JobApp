package com.testingxperts.JobApp.Company.Services;

import com.testingxperts.JobApp.Company.Models.Company;
import com.testingxperts.JobApp.Job.Models.Job;

import java.util.List;

public interface CompanyService
{
    List<Company> getAllCompanies();
    boolean updateCompany(Long id,Company company);
    void createCompany(Company company);
    Company getCompanyById(Long id);
    boolean deleteCompany(Long id);
}
