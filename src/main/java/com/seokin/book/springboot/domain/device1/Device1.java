package com.seokin.book.springboot.domain.device1;

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
@Entity(name = "device1")
public class Device1 {

    @Id//pk필드 적용
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment 적용
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String logtime;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String loadage;


    @Builder
    public Device1(String logtime, String loadage) {
        this.logtime = logtime;
        this.loadage = loadage;
    }

    public void update(String logtime, String loadage) {
        this.logtime = logtime;
        this.loadage = loadage;
    }

}