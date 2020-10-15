package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device3.Device3;
import lombok.Getter;

@Getter
public class Device3ListResponseDto {
    private Long id;
    private String date_time;
    private String loadage;

    public Device3ListResponseDto(Device3 entity) {
        this.id = entity.getId();
        this.date_time = entity.getDate_time();
        this.loadage = entity.getLoadage();
    }
}
