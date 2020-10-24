package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device2.Device2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Device2SaveRequestDto {
    private String logtime;
    private String loadage;

    @Builder
    public Device2SaveRequestDto(String logtime, String loadage) {
        this.logtime = getLogtime();
        this.loadage = getLoadage();
    }

    public Device2 toEntity() {
        return Device2.builder()
                .logtime(logtime)
                .loadage(loadage)
                .build();
    }

}
