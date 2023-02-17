package com.with.hyuil.controller.hotel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.with.hyuil.dto.hotel.GlobalPageHandler;
import com.with.hyuil.dto.hotel.HotelListDto;
import com.with.hyuil.dto.hotel.HotelSearchDto;
import com.with.hyuil.service.interfaces.HotelService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelSearchController {
    private final HotelService hotelService;

    @GetMapping("/list")
    public String hotelList(@ModelAttribute HotelSearchDto hotelSearchDto, Model model) {
        log.info("호텔 제대로 들어왔음? = {}", hotelSearchDto);
        return searchHotels(model, hotelSearchDto);
    }

    @GetMapping("/list/{region}")
    public String indexHotelList(@PathVariable String region, Model model) {
        log.info("지역? = {}", region);
        String today = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        log.info("오늘은 ? = {}", today);
        HotelSearchDto hotelSearchDto = new HotelSearchDto(region, 1, today, today);
        return searchHotels(model, hotelSearchDto);
    }

    private String searchHotels(Model model, HotelSearchDto hotelSearchDto) {

        List<HotelListDto> hotelList = hotelService.searchHotels(hotelSearchDto);
        log.info("hotelListDto = {}", hotelList);
        try {
            GlobalPageHandler globalPageHandler = new GlobalPageHandler(hotelList.get(0).getTotcnt(), 1);
            log.info("핸들러 = {}", globalPageHandler);
            model.addAttribute("ph", globalPageHandler);
            model.addAttribute(hotelList);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과가 없습니다");
            return "hotel/hotelList";
        }
        return "hotel/hotelList";
    }
}