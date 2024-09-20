package com.testingxperts.JobApp.Review.Controllers;

import com.testingxperts.JobApp.Review.Models.Review;
import com.testingxperts.JobApp.Review.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}/reviews")
public class ReviewController
{
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviewsByCompany(@PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.findAll(companyId), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId)
    {
        Review review = reviewService.getReviewById(companyId,reviewId);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review)
    {
        boolean saved = reviewService.createReview(companyId,review);
        if(saved)
        {
            return new ResponseEntity<>("Review Added Successfully",HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review)
    {
        boolean updated = reviewService.updateReviewById(companyId, reviewId, review);
        if(updated)
        {
            return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId)
    {
        boolean deleted = reviewService.deleteReview(companyId, reviewId);
        if(deleted)
        {
            return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
