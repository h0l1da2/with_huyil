package com.with.hyuil.dao;

import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.BookPageDto;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.model.BookVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    BookVo findById(Long id);
    List<BookListDto> findAllByUserId(BookSearchDto bookSearchDto);
    int countForBookList(BookSearchDto bookSearchDto);
    int countForHostInfo(BookSearchDto bookSearchDto);
    int countForAdminBook(BookPageDto bookPageDto);
    List<HostBookListDto> findAllForHostInfo(BookSearchDto bookSearchDto);
    List<AdminBookListDto> findAllForAdmin(BookPageDto bookPageDto);
    int updateRemoveDate(Long id);
    void insertBook(BookAddDto bookAddDto);
}
