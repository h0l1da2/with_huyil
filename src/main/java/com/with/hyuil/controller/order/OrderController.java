package com.with.hyuil.controller.order;


import com.with.hyuil.KakaoPay;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.model.HotelVo;
import com.with.hyuil.model.OrdersVo;
import com.with.hyuil.model.RoomVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.RoomServiceImpl;
import com.with.hyuil.service.interfaces.BookService;
import com.with.hyuil.service.interfaces.HotelService;
import com.with.hyuil.service.interfaces.OrderService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final UsersService usersService;
    private final HotelService hotelService;
    private final RoomServiceImpl roomService;
    private final OrderService ordersService;
    private final BookService bookService;

    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;

    @PostMapping("/kakaoPay")
    public String kakaoPay(HttpServletRequest req, @RequestParam("checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate checkin,
                           @RequestParam("checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate checkout, @RequestParam("roomId") long roomId) {
        log.info("kakaoPay post............................................");
        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");
        int price = Integer.parseInt(req.getParameter("price"));
        String name = req.getParameter("name");
        String please = req.getParameter("please");
        int date = (ordersService.getDatesBetweenTwoDates(checkin, checkout)).size();
        int total_amountint = price * date;
        String day = String.valueOf(date);
        String total_amount = Integer.toString(total_amountint);
        String checkinstr = checkin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String checkoutstr = checkout.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String daytoday = checkinstr + " ~ " + checkoutstr;
        return "redirect:" + kakaopay.kakaoPayReady(name, userId, userName, total_amount, day, daytoday, roomId, please);
    }

    @RequestMapping("/kakaoPaySuccess")
    public String Kim(HttpServletRequest req, Model model, @RequestParam("pg_token") String pg_token, @RequestParam("userId") String userId, @RequestParam("totalPrice") int totalPrice,
                      @RequestParam("userName") String userName, @RequestParam("day") String day, @RequestParam("item") String item, @RequestParam("roomId") long roomId,
                      @RequestParam("please") String please, RedirectAttributes re) {
        UsersVo usersvo = usersService.loginForFind(userId);
        RoomVo roomvo = roomService.findByRoomId(roomId);
        HotelVo hotelvo = hotelService.findByHotelId(roomvo.getHotelId());
        String total_amount = String.valueOf(totalPrice);
        OrdersVo ordersvo = new OrdersVo();
        ordersvo.setUserId(usersvo.getId());
        ordersvo.setTotalPrice(totalPrice);
        String date[] = day.split(" ~ ");
        LocalDate checkIn = LocalDate.parse(date[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate checkOut = LocalDate.parse(date[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ordersvo.setCheckin(checkIn);
        ordersvo.setCheckout(checkOut);
        long hostId = hotelService.getHostId(hotelvo.getId());
        ordersvo.setHostId(hostId);
        ordersvo.setTid(kakaopay.kakaoPayInfo(pg_token, total_amount).getTid());
        ordersvo.setUserName(userName);
        String hotelRoom[] = item.split(" / ");
        ordersvo.setHotel(hotelRoom[0]);
        ordersvo.setRoom(hotelRoom[1]);
        ordersvo.setPgToken(pg_token);
        ordersService.addOrders(ordersvo);
        BookAddDto bookAddDto = new BookAddDto();
        bookAddDto.setUserId(usersvo.getId());
        bookAddDto.setRoomId(roomId);
        bookAddDto.setPlease(please);
        Date check1 = java.sql.Date.valueOf(checkIn);
        Date check2 = java.sql.Date.valueOf(checkOut);
        bookAddDto.setCheckIn(check1);
        bookAddDto.setCheckOut(check2);
        bookAddDto.setOrderId(ordersvo.getId());
        bookService.addBook(bookAddDto);
        re.addAttribute("pg_token", pg_token);
        return "redirect:/orderComplete";
    }

    @GetMapping("/orderComplete")
    public String MinJae(Model model, @RequestParam("pg_token") String pgToken){
        OrdersVo ordersvo = ordersService.findByToken(pgToken);
        String now = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초").format(ordersvo.getOrderDate());
        model.addAttribute("now", now);
        model.addAttribute("orders", ordersvo);
        return "/order/orderComplete";
    }

    @GetMapping("/hotel/kakaoPayCancel")
    public String Wall() {
        return "/order/kakaoPayCancel";
    }

}

