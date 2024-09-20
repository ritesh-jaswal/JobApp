package com.testingxperts.JobApp.Review.Services;

import com.testingxperts.JobApp.Review.Models.Review;

import java.util.List;

public interface ReviewService
{
    List<Review> findAll(Long companyId);
    boolean createReview(Long companyId,Review review);
    Review getReviewById(Long companyId,Long reviewId);
    boolean deleteReview(Long companyId,Long reviewId);
    boolean updateReviewById(Long companyId,Long reviewId, Review review);
}
