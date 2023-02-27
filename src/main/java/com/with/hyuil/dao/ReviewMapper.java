package com.with.hyuil.dao;

import com.with.hyuil.dto.review.ReviewDto;
import com.with.hyuil.dto.review.StarDto;
import com.with.hyuil.model.ReviewVo;
import com.with.hyuil.model.StarVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    int insertStar(StarVo starVo);
    int insertReview(ReviewVo reviewVo);
    int insertHostReview(ReviewVo reviewVo);
    List<ReviewDto> selectAllReviews(Long hotelId1);
    ReviewVo selectFromId(Long id);
    StarDto selectSumStar(Long id);
}
