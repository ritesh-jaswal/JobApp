package com.testingxperts.JobApp.Review.ServiceImpls;

import com.testingxperts.JobApp.Company.Models.Company;
import com.testingxperts.JobApp.Company.Services.CompanyService;
import com.testingxperts.JobApp.Job.Models.Job;
import com.testingxperts.JobApp.Review.Models.Review;
import com.testingxperts.JobApp.Review.Repositories.ReviewRepo;
import com.testingxperts.JobApp.Review.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService
{
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> findAll(Long companyId)
    {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId,Review review)
    {
        Company company = companyService.getCompanyById(companyId);
        if(company != null)
        {
            review.setCompany(company);
            reviewRepo.save(review);

            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId,Long reviewId)
    {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        Review rev =  reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);

        return rev;
    }

    @Override
    public boolean deleteReview(Long companyId,Long reviewId)
    {
        if(companyService.getCompanyById(companyId)!=null &&
        reviewRepo.existsById(reviewId))
        {
            Review review = reviewRepo.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(companyId,company);
            reviewRepo.deleteById(reviewId);

            return true;
        }
        return false;
    }

    @Override
    public boolean updateReviewById(Long companyId,Long reviewId, Review review)
    {
        if(companyService.getCompanyById(companyId)!=null)
        {
            review.setCompany(companyService.getCompanyById(companyId));
            review.setId(reviewId);
            reviewRepo.save(review);
            return true;
        }
        return false;
    }
}
