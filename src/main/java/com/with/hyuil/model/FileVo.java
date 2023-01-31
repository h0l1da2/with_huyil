package com.with.hyuil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileVo {

    private Long id;
    private String type;
    private String name;
    private String uuid;
    private String path;
    private Long size;
    private String removed;
}
