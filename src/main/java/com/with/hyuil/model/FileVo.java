package com.with.hyuil.model;

import lombok.Data;

@Data
public class FileVo {

    private long id;
    private String type;
    private String name;
    private String uuid;
    private String path;
    private long size;
    private String removeDate;
    private long hotelInfoId;
    private long roomId;
}