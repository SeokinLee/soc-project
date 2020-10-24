package com.seokin.book.springboot.web;

import com.seokin.book.springboot.service.Device4Service;
import com.seokin.book.springboot.web.dto.Device4ListResponseDto;
import com.seokin.book.springboot.web.dto.Device4ResponseDto;
import com.seokin.book.springboot.web.dto.Device4SaveRequestDto;
import com.seokin.book.springboot.web.dto.Device4UpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Device4ApiController {

    private Device4Service device4Service;

    //등록
    @PostMapping("/api/v1/device4")
    public Long save(@RequestBody Device4SaveRequestDto requestDto) {
        return device4Service.save(requestDto);
    }

    //수정
    @PutMapping("/api/v1/device4/{id}")
    public Long update(@PathVariable Long id, @RequestBody Device4UpdateRequestDto requestDto) {
        return device4Service.update(id, requestDto);
    }

    //삭제
    @DeleteMapping("/api/v1/device4/{id}")
    public Long delete(@PathVariable Long id) {
        device4Service.delete(id);
        return id;
    }

    //조회
    @GetMapping("/api/v1/device4/{id}")
    public Device4ResponseDto findById(@PathVariable Long id) {
        return device4Service.findById(id);
    }

    @GetMapping("/api/v1/device4/list")
    public List<Device4ListResponseDto> findAll() {
        return device4Service.findAllDesc();
    }
}
