package com.seokin.book.springboot.domain.posts;

import com.seokin.book.springboot.domain.BaseTimeEntity;
//import com.sun.imageio.plugins.common.SingleTileRenderedImage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String device_nm;

    @Column(length = 500, nullable = false)
    private String serial_no;
    @Column(length = 500, nullable = true)
    private String loadage;

    @Column(length = 500, nullable = false)
    private String latitude;

    //@Column(columnDefinition = "TEXT", nullable = true)
    @Column(length = 500, nullable = false)
    private String longitude;

    @Column(length = 500, nullable = true)
    private String address;


    @Builder
    public Posts(String device_nm, String serial_no, String loadage, String latitude, String longitude, String address) {
        this.device_nm = device_nm;
        this.serial_no = serial_no;
        this.loadage = loadage;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public void update(String device_nm, String serial_no, String loadage, String latitude, String longitude, String address) {
        this.device_nm = device_nm;
        this.serial_no = serial_no;
        this.loadage = loadage;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

}
