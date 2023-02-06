package com.with.hyuil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Booking;
import model.Business;
import model.Picture;
import model.Reserved;
import model.Review;
import model.Room;
import repository.ReserveDao;
import repository.BookingDao;
import util.DateParse;

@Service
public class ReserveService {
	
	private final ReserveDao reserveDao;
	private final BookingDao bookingDao;
	
	@Autowired
	public ReserveService(ReserveDao reserveDao, BookingDao bookingDao) {
		this.reserveDao = reserveDao;
		this.bookingDao = bookingDao;
	}

	public Business getReviewAvgCountBusiness(String bu_email, String email) throws Exception {
		return reserveDao.reviewAvgCountBusinessOne(bu_email, email);
	}
	
	public List<Picture> getPicList(int pic_num) throws Exception {
		return reserveDao.getPicList(pic_num);
	}
	
	public List<Room> getOverlapRoomList(String bu_email, String ro_count,
										String checkin, String checkout) throws Exception{
		return reserveDao.overlapRoomList(bu_email, ro_count, checkin, checkout);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int insertBooking(Booking booking) throws Exception {
		int result = reserveDao.insertBooking(booking);
		
		if(result == 0) {
			return 0;
		} else {
			// 날짜 차이 계산
			int dif = DateParse.dateDif(booking.getCheckin(), booking.getCheckout());

			// 체크인 날짜 ~ 체크아웃 날짜 -1
			for(int i=0; i<dif ;i++) {
				reserveDao.insertReserved( 
						new Reserved(booking.getRo_num(), 
									DateParse.datePlus(booking.getCheckin(), i)) );
			}
			return 1;
		}
	}
	
	public Room getRoom(int ro_num) throws Exception {
		return reserveDao.roomSelectOne(ro_num);
	}
	
	// 상태 변경 후 예약 중복 테이블 삭제
	@Transactional(rollbackFor = Exception.class)
	public int reserveCancel(String bo_num) throws Exception {
		
		int result = bookingDao.updateBookingStatus(bo_num);
		
		if(result == 0) {
			return 0;
		} else { // 예약 중복 내역 삭제
			Booking b = bookingDao.getBookingSelectDetail(bo_num);
			b.setCheckout(DateParse.datePlus(b.getCheckout(), -1));							
			return reserveDao.cancelReserveList(b);
		}
		
	}
	
	public Booking getBooking(String bo_num) throws Exception {
		return bookingDao.getBookingSelectDetail(bo_num);
	}
	
	public List<Booking> getMemberBookingList(String email) throws Exception {
		return bookingDao.selectBookingPicRevList(email);
	}

	public List<Review> businessReviewList(String bu_email) {
		return bookingDao.businessReviewList(bu_email);
	}
}
