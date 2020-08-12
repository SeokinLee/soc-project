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
    private String location;

    @Builder
    public PostsSaveRequestDto(String device_nm, String serial_no, String loadage, String location) {
        this.device_nm = device_nm;
        this.serial_no = serial_no;
        this.loadage = loadage;
        this.location = location;
    }

    public Posts toEntity() {
        return Posts.builder()
                .device_nm(device_nm)
                .serial_no(serial_no)
                .loadage(loadage)
                .location(location)
                .build();
    }

}
