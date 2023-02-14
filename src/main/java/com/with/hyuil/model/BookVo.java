package com.with.hyuil.model;

import com.with.hyuil.model.enumaration.Status;
import lombok.Getter;

import java.util.Date;

@Getter
public class BookVo {
    private Long id;
    private Long userId;
    private Long roomId;
    private String please;
    private Integer count;
    private Date checkIn;
    private Date checkOut;
    private Status status;
    private Long orderId;

    protected BookVo() {
    }

    public BookVo(Long id, Long userId, Long roomId, String please, Integer count, Date checkIn, Date checkOut, Status status, Long orderId) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.please = please;
        this.count = count;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.orderId = orderId;
    }
}