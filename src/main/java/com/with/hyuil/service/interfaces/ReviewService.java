package com.with.hyuil.service.interfaces;

import com.with.hyuil.model.ReviewVo;
import com.with.hyuil.model.StarVo;

public interface ReviewService {

    StarVo saveStar(StarVo starVo);
    ReviewVo writeReview(ReviewVo reviewVo);

}
