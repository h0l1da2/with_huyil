package com.with.hyuil.dao;


import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.AdminPageDto;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.dto.review.ReviewBookDto;
import com.with.hyuil.model.BookVo;
import com.with.hyuil.model.ReviewVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    BookVo findById(Long id);
    List<BookListDto> findAllByUserId(BookSearchDto bookSearchDto);
    int countForBookList(BookSearchDto bookSearchDto);
    int countForHostInfo(BookSearchDto bookSearchDto);
    int countForAdminBook(AdminPageDto adminPageDto);
    List<HostBookListDto> findAllForHostInfo(BookSearchDto bookSearchDto);
    List<AdminBookListDto> findAllForAdmin(AdminPageDto adminPageDto);
    int updateRemoveDate(Long id);
    List<BookVo> findBookForReview(ReviewBookDto bookVo);
    int updateReviewId(ReviewVo reviewVo);
    void insertBook(BookAddDto bookAddDto);
    int updateStatus(HostBookListDto hostBookListDto);
}
