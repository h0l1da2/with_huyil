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
    private String removed;
    private long hotel_info_id;
    private long room_id;
}
