package com.with.hyuil.dto.admin;

import com.with.hyuil.model.enumaration.Status;
import lombok.Data;

@Data
public class AdminBookListDto {

    private Long id;
    private String userId;
    private String hotel;
    private String orderDate;
    private String checkIn;
    private String checkOut;
    private Status status;
    private Integer totcnt;

}
