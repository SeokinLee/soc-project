package com.seokin.book.springboot.web.dto;

import com.seokin.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String device_nm;
    private String serial_no;
    private String location;
    private String loadage;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.device_nm = entity.getDevice_nm();
        this.serial_no = entity.getSerial_no();
        this.location = entity.getLocation();
        this.loadage = entity.getLoadage();
        this.modifiedDate = entity.getModifiedDate();
    }
}
