package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device4.Device4;
import lombok.Getter;

@Getter
public class Device4ListResponseDto {
    private Long id;
    private String date_time;
    private String loadage;

    public Device4ListResponseDto(Device4 entity) {
        this.id = entity.getId();
        this.date_time = entity.getDate_time();
        this.loadage = entity.getLoadage();
    }
}
