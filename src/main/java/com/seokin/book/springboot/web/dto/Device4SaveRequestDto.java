package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device4.Device4;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Device4SaveRequestDto {
    private String logtime;
    private String loadage;

    @Builder
    public Device4SaveRequestDto(String logtime, String loadage) {
        this.logtime = getLogtime();
        this.loadage = getLoadage();
    }

    public Device4 toEntity() {
        return Device4.builder()
                .logtime(logtime)
                .loadage(loadage)
                .build();
    }

}
