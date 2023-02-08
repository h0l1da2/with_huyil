package com.with.hyuil.dto.info;

import lombok.Data;

@Data
public class HostBookListDto {
    private Long id;
    private Integer totcnt;
    private String room;
    private String name;
    private Integer count;
    private String checkIn;
    private String checkOut;
    private String please;
}
