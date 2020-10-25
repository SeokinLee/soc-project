package com.seokin.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String device_nm;
    private String serial_no;
    //private String current_loadage;
    private String latitude;
    private String longitude;
    private String address;

    @Builder
    public PostsUpdateRequestDto(String device_nm, String serial_no, /*String current_loadage, */String latitude, String longitude, String address) {
        this.device_nm = device_nm;
        this.serial_no = serial_no;
        //this.current_loadage = current_loadage;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }
}
