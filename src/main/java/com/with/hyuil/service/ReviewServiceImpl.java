package com.with.hyuil.service;

import com.with.hyuil.dao.ReviewMapper;
import com.with.hyuil.dto.review.ReviewDto;
import com.with.hyuil.model.ReviewVo;
import com.with.hyuil.model.StarVo;
import com.with.hyuil.service.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;

    @Override
    public StarVo saveStar(StarVo starVo) {
        log.info("스타 있음 ? = {}", starVo.getOrganic());
        reviewMapper.insertStar(starVo);
        log.info("스타브이오 아이디 드감? = {}", starVo.getId());
        return starVo;
    }

    @Override
    public ReviewVo writeReview(ReviewVo reviewVo) {
        reviewMapper.insertReview(reviewVo);
        return reviewVo;
    }

    @Override
    public List<ReviewDto> findHotelReviews(Long hotelId) {
        return reviewMapper.selectAllReviews(hotelId);
    }
}
