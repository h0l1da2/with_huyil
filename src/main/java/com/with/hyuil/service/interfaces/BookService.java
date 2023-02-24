package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.AdminPageDto;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.dto.review.ReviewBookDto;
import com.with.hyuil.model.BookVo;
import com.with.hyuil.model.ReviewVo;

import java.util.List;

public interface BookService {

    List<BookListDto> userBookList(BookSearchDto bookSearchDto);
    List<HostBookListDto> hostBookList(BookSearchDto bookSearchDto);
    List<AdminBookListDto> adminBookList(AdminPageDto adminPageDto);
    BookVo notReviewFind(ReviewBookDto bookVo);
    int writeBookReview(ReviewVo reviewVo);
    String bookCancel(Long id);
    String hostBookCancel(Long id);
    void addBook(BookAddDto bookAddDto);
}