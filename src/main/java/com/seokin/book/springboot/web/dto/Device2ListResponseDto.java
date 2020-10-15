package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device2.Device2;
import lombok.Getter;

@Getter
public class Device2ListResponseDto {
    private Long id;
    private String date_time;
    private String loadage;

    public Device2ListResponseDto(Device2 entity) {
        this.id = entity.getId();
        this.date_time = entity.getDate_time();
        this.loadage = entity.getLoadage();
    }
}
