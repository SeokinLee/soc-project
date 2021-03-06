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
    //private String current_loadage;
    private String latitude;
    private String longitude;
    private String address;

    @Builder
    public PostsSaveRequestDto(String device_nm, String serial_no, /*String current_loadage, */String latitude, String longitude, String address) {
        this.device_nm = device_nm;
        this.serial_no = serial_no;
        //this.current_loadage = current_loadage;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public Posts toEntity() {
        return Posts.builder()
                .device_nm(device_nm)
                .serial_no(serial_no)
                //.current_loadage(current_loadage)
                .latitude(latitude)
                .longitude(longitude)
                .address(address)
                .build();
    }

}
