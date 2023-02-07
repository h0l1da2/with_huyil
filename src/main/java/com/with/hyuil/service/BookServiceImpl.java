package com.with.hyuil.service;

import com.with.hyuil.dao.BookMapper;
import com.with.hyuil.dto.hotel.GlobalPageHandler;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.model.enumaration.Status;
import com.with.hyuil.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    @Override
    public List<BookListDto> bookList(BookSearchDto bookSearchDto) {
        int totalCnt = bookMapper.countForBookList(bookSearchDto);
        GlobalPageHandler globalPageHandler = new GlobalPageHandler(totalCnt, bookSearchDto.getViewPage());
        log.info("글로벌페이지핸들러ㅋㅋ = {}", globalPageHandler);
        log.info("북서치디티오 = {}", bookSearchDto);
        bookSearchDto.calcPage(globalPageHandler.getOffsetPost());
        log.info("북서치디티오 정렬 = {}", bookSearchDto);
        return bookMapper.findAllByUserId(bookSearchDto);
    }
}
