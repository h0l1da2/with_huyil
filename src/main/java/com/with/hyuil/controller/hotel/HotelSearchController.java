package com.with.hyuil.controller.hotel;

import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelPageHandler;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.service.interfaces.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelSearchController {
    private final HotelService hotelService;

    @GetMapping("/list")
    public String hotelList(@ModelAttribute HotelSearchDto hotelSearchDto, Model model) {
        log.info("호텔 제대로 들어왔음? = {}", hotelSearchDto);
        List<HotelListDto> hotelList = hotelService.searchHotels(hotelSearchDto);
        log.info("hotelListDto = {}", hotelList);
        try {
            HotelPageHandler hotelPageHandler = new HotelPageHandler(hotelList.get(0).getTotcnt(), 1);
            log.info("핸들러 = {}", hotelPageHandler);
            model.addAttribute("ph", hotelPageHandler);
            model.addAttribute(hotelList);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과가 없습니다");
            return "hotel/hotelList";
        }
        return "hotel/hotelList";
    }
}
