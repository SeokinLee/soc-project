package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device1.Device1;
import lombok.Getter;

@Getter
public class Device1ResponseDto {

    private Long id;
    private String logtime;
    private String loadage;

    public Device1ResponseDto(Device1 entity) {
        this.id = entity.getId();
        this.logtime = entity.getLogtime();
        this.loadage = entity.getLoadage();
    }
}
