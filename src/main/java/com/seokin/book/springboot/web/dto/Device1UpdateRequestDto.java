package com.seokin.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Device1UpdateRequestDto {
    private String logtime;
    private String loadage;

    @Builder
    public Device1UpdateRequestDto(String logtime, String loadage) {
        this.logtime = getLogtime();
        this.loadage = getLoadage();
    }
}
