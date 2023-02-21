package com.with.hyuil.dao;

import com.with.hyuil.model.ReviewVo;
import com.with.hyuil.model.StarVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

    int insertStar(StarVo starVo);
    int insertReview(ReviewVo reviewVo);
}
