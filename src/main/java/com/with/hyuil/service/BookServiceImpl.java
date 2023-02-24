package com.with.hyuil.service;

import com.with.hyuil.dao.BookMapper;
import com.with.hyuil.dto.hotel.GlobalPageHandler;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.model.BookVo;
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
    public List<BookListDto> userBookList(BookSearchDto bookSearchDto) {
        int totalCnt = bookMapper.countForBookList(bookSearchDto);
        GlobalPageHandler globalPageHandler = new GlobalPageHandler(totalCnt, bookSearchDto.getViewPage());
        bookSearchDto.calcPage(globalPageHandler.getOffsetPost());
        return bookMapper.findAllByUserId(bookSearchDto);
    }

    @Override
    public List<HostBookListDto> hostBookList(BookSearchDto bookSearchDto) {
        int totalCnt = bookMapper.countForHostInfo(bookSearchDto);
        GlobalPageHandler globalPageHandler = new GlobalPageHandler(totalCnt, bookSearchDto.getViewPage());
        log.info("글로벌핸들러서비스 ? = {}", globalPageHandler);
        bookSearchDto.calcPage(globalPageHandler.getOffsetPost());
        log.info("북서치디티오 ? = {}", bookSearchDto);
        return bookMapper.findAllForHostInfo(bookSearchDto);
    }

    @Override
    public String hostBookCancel(Long id) {
        int i = bookMapper.updateRemoveDate(id);

        if (i == 0) {
            return "업데이트 실패";
        }
        return "예약 취소 완료";
    }
    
    @Override
    public void addBook(BookAddDto bookAddDto) {
    	bookMapper.insertBook(bookAddDto);
    }
}