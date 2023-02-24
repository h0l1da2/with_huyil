package com.with.hyuil.service.interfaces;

import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.BookPageDto;
import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.model.BookVo;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;

import java.util.List;

public interface BookService {

    List<BookListDto> userBookList(BookSearchDto bookSearchDto);
    List<HostBookListDto> hostBookList(BookSearchDto bookSearchDto);
    List<AdminBookListDto> adminBookList(BookPageDto bookPageDto);
    String bookCancel(Long id);
    String hostBookCancel(Long id);
    void addBook(BookAddDto bookAddDto);
}