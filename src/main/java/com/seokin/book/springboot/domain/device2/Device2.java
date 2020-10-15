package com.seokin.book.springboot.domain.device2;

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
public class Device2 {

    @Id//pk필드 적용
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment 적용
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String date_time;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String loadage;

    @Builder
    public Device2(String date_time, String loadage) {
        this.date_time = date_time;
        this.loadage = loadage;
    }
}