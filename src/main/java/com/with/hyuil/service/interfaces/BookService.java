package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.BookPageDto;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.dto.review.ReviewBookDto;
import com.with.hyuil.model.BookVo;

import java.util.List;

public interface BookService {

    List<BookListDto> userBookList(BookSearchDto bookSearchDto);
    List<HostBookListDto> hostBookList(BookSearchDto bookSearchDto);
    List<AdminBookListDto> adminBookList(BookPageDto bookPageDto);
    BookVo notReviewFind(ReviewBookDto bookVo);
    String bookCancel(Long id);
}