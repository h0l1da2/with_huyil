package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.review.ReviewDto;
import com.with.hyuil.dto.review.StarDto;
import com.with.hyuil.model.ReviewVo;
import com.with.hyuil.model.StarVo;

import java.util.List;

public interface ReviewService {

    StarVo saveStar(StarVo starVo);
    ReviewVo writeReview(ReviewVo reviewVo);
    ReviewVo writeHostReview(ReviewVo reviewVo);
    List<ReviewDto> findHotelReviews(Long id);
    ReviewDto findReviewBook(Long id);
    StarDto getHotelStar(Long id);
}
