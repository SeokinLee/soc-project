package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String device_nm;
    private String serial_no;
    private String latitude;
    private String longitude;
    private String current_loadage;
    private String address;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.device_nm = entity.getDevice_nm();
        this.serial_no = entity.getSerial_no();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.current_loadage = entity.getCurrent_loadage();
        this.address = entity.getAddress();
        this.modifiedDate = entity.getModifiedDate();
    }
}
