package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.review.ReviewDto;
import com.with.hyuil.model.ReviewVo;
import com.with.hyuil.model.StarVo;

import java.util.List;
import java.util.Map;

public interface ReviewService {

    StarVo saveStar(StarVo starVo);
    ReviewVo writeReview(ReviewVo reviewVo);
    List<ReviewDto> findHotelReviews(Long id);
}
