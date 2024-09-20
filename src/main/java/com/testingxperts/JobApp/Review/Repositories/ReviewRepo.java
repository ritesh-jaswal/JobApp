package com.testingxperts.JobApp.Review.Repositories;

import com.testingxperts.JobApp.Review.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {
    List<Review> findByCompanyId(Long companyId);
}
