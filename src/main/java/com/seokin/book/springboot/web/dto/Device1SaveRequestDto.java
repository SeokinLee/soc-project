package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device1.Device1;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Device1SaveRequestDto {
    private String logtime;
    private String loadage;

    @Builder
    public Device1SaveRequestDto(String logtime, String loadage) {
        this.logtime = getLogtime();
        this.loadage = getLoadage();
    }

    public Device1 toEntity() {
        return Device1.builder()
                .logtime(logtime)
                .loadage(loadage)
                .build();
    }

}
