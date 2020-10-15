package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String device_nm;
    private String serial_no;
    private String loadage;
    private String address;
    private String latitude;
    private String longitude;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.device_nm = entity.getDevice_nm();
        this.serial_no = entity.getSerial_no();
        this.loadage = entity.getLoadage();
        this.address = entity.getAddress();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
    }
}
