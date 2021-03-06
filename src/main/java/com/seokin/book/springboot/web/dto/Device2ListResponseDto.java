package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device2.Device2;
import lombok.Getter;

@Getter
public class Device2ListResponseDto {
    private Long id;
    private String logtime;
    private String loadage;

    public Device2ListResponseDto(Device2 entity) {
        this.id = entity.getId();
        this.logtime = entity.getLogtime();
        this.loadage = entity.getLoadage();
    }
}
