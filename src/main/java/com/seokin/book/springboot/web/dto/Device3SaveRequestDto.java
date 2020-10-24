package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.device3.Device3;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Device3SaveRequestDto {
    private String logtime;
    private String loadage;

    @Builder
    public Device3SaveRequestDto(String logtime, String loadage) {
        this.logtime = getLogtime();
        this.loadage = getLoadage();
    }

    public Device3 toEntity() {
        return Device3.builder()
                .logtime(logtime)
                .loadage(loadage)
                .build();
    }

}
