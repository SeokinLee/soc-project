package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String device_nm;
    private String serial_no;
    private String loadage;
    private String latitude;
    private String longitude;

    @Builder
    public PostsSaveRequestDto(String device_nm, String serial_no, String loadage, String latitude, String longitude) {
        this.device_nm = device_nm;
        this.serial_no = serial_no;
        this.loadage = loadage;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Posts toEntity() {
        return Posts.builder()
                .device_nm(device_nm)
                .serial_no(serial_no)
                .loadage(loadage)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }

}
