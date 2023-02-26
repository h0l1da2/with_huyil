package com.with.hyuil.service;

import com.with.hyuil.dao.BookMapper;
import com.with.hyuil.dto.admin.AdminBookListDto;
import com.with.hyuil.dto.admin.AdminPageDto;
import com.with.hyuil.dto.admin.TenPageHandler;
import com.with.hyuil.dto.hotel.GlobalPageHandler;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.dto.info.BookListDto;
import com.with.hyuil.dto.info.BookSearchDto;
import com.with.hyuil.dto.info.HostBookListDto;
import com.with.hyuil.dto.review.ReviewBookDto;
import com.with.hyuil.model.BookVo;
import com.with.hyuil.model.ReviewVo;
import com.with.hyuil.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    @Override
    public List<BookListDto> userBookList(BookSearchDto bookSearchDto) {
        int totalCnt = bookMapper.countForBookList(bookSearchDto);
        getBookCount(bookSearchDto, totalCnt);
        return bookMapper.findAllByUserId(bookSearchDto);
    }

    @Override
    public List<HostBookListDto> hostBookList(BookSearchDto bookSearchDto) {
        int totalCnt = bookMapper.countForHostInfo(bookSearchDto);
        getBookCount(bookSearchDto, totalCnt);
        return bookMapper.findAllForHostInfo(bookSearchDto);
    }

    @Override
    public List<AdminBookListDto> adminBookList(AdminPageDto adminPageDto) {
        int totalCnt = bookMapper.countForAdminBook(adminPageDto);
        TenPageHandler tenPageHandler = new TenPageHandler(totalCnt, adminPageDto.getViewPage());
        adminPageDto.calcPage(tenPageHandler.getOffsetPost());
        return bookMapper.findAllForAdmin(adminPageDto);
    }

    @Override
    public BookVo notReviewFind(ReviewBookDto reviewBookDto) {
        List<BookVo> bookReviews = bookMapper.findBookForReview(reviewBookDto);
        if (bookReviews.size() != 0) {
            return bookReviews.get(0);
        }
        return null;
    }

    @Override
    public int writeBookReview(ReviewVo reviewVo) {
        return bookMapper.updateReviewId(reviewVo);
    }

    @Override
    public String bookCancel(Long id) {
        int i = bookMapper.updateRemoveDate(id);

        if (i == 0) {
            return "업데이트 실패";
        }
        return "예약 취소 완료";
    }

    private void getBookCount(BookSearchDto bookSearchDto, int totalCnt) {
        GlobalPageHandler globalPageHandler = new GlobalPageHandler(totalCnt, bookSearchDto.getViewPage());
        bookSearchDto.calcPage(globalPageHandler.getOffsetPost());
    }
    @Override
    public void addBook(BookAddDto bookAddDto) {
            bookMapper.insertBook(bookAddDto);
        }
    @Override
    public String hostBookCancel(Long id) {
        return null;
    }

}