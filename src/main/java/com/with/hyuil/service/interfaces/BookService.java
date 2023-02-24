package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.model.BookVo;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;

import java.util.List;

public interface BookService {

    List<BookListDto> userBookList(BookSearchDto bookSearchDto);
    List<HostBookListDto> hostBookList(BookSearchDto bookSearchDto);
    String hostBookCancel(Long id);
    void addBook(BookAddDto bookAddDto);
}