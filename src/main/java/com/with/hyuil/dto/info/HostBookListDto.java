package com.with.hyuil.dto.info;

import com.with.hyuil.model.enumaration.Status;
import lombok.Data;

@Data
public class HostBookListDto {
    private Long id;
    private Status status;
    private Integer totcnt;
    private String room;
    private String name;
    private Integer count;
    private String checkIn;
    private String checkOut;
    private String please;
}
