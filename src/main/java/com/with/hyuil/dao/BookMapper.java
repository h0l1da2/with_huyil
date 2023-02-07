package com.with.hyuil.dao;

import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.model.BookVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    BookVo findById(Long id);
    List<BookListDto> findAllByUserId(BookSearchDto bookSearchDto);
    int countForBookList(BookSearchDto bookSearchDto);
}
