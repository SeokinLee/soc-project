package com.seokin.book.springboot.domain.posts;

import com.seokin.book.springboot.domain.BaseTimeEntity;
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

    private String serial_no;

    //@Column(columnDefinition = "TEXT", nullable = true)
    private String loadage;

    private String location;


    @Builder
    public Posts(String device_nm, String serial_no, String loadage, String location) {
        this.device_nm = device_nm;
        this.serial_no = serial_no;
        this.loadage = loadage;
        this.location = location;
    }

    public void update(String device_nm, String serial_no) {
        this.device_nm = device_nm;
        this.serial_no = serial_no;
        //this.loadage = loadage;
        //this.location = location;
    }
}
