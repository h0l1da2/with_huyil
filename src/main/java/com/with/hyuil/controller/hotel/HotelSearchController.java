package com.with.hyuil.controller.hotel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.with.hyuil.dto.hotel.StarDto;
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
    private GlobalPageHandler globalPageHandler;

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
        List<StarDto> starList = hotelService.searchHotelStar(hotelList);
        log.info("hotelListDto = {}", hotelList);
        log.info("starList = {}", starList);

        if (starList != null) {
            for(StarDto star : starList) {
                star.calcForHotelList();
                for(HotelListDto hotelListDto : hotelList) {
                    if(star.getId().equals(hotelListDto.getId())) {
                        hotelListDto.setStar(star.getReviewStars());
                    }
                }
            }
        }
        try {
            globalPageHandler = new GlobalPageHandler(hotelList.get(0).getTotcnt(), 1);
            log.info("핸들러 = {}", globalPageHandler);
            log.info("hotelSearchDto = {}", hotelSearchDto);
            addModelForList(model, hotelSearchDto, hotelList, globalPageHandler);
        } catch (IndexOutOfBoundsException e) {
            log.info("검색 결과가 없습니다");
            addModelForList(model, hotelSearchDto, hotelList, globalPageHandler);
            return "hotel/hotelList";
        }
        return "hotel/hotelList";
    }

    private void addModelForList(Model model, HotelSearchDto hotelSearchDto, List<HotelListDto> hotelList, GlobalPageHandler globalPageHandler) {
        if (globalPageHandler == null) {
            globalPageHandler =  new GlobalPageHandler(0, 1);
        }
        model.addAttribute("ph", globalPageHandler);
        model.addAttribute(hotelList);
        model.addAttribute("where", hotelSearchDto.getSido());
    }
}