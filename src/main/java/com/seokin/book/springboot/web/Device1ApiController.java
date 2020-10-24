package com.seokin.book.springboot.web;

import com.seokin.book.springboot.service.Device1Service;
import com.seokin.book.springboot.web.dto.Device1ListResponseDto;
import com.seokin.book.springboot.web.dto.Device1ResponseDto;
import com.seokin.book.springboot.web.dto.Device1SaveRequestDto;
import com.seokin.book.springboot.web.dto.Device1UpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Device1ApiController {

    private Device1Service device1Service;

    //등록
    @PostMapping("/api/v1/device1")
    public Long save(@RequestBody Device1SaveRequestDto requestDto) {
        return device1Service.save(requestDto);
    }

    //수정
    @PutMapping("/api/v1/device1/{id}")
    public Long update(@PathVariable Long id, @RequestBody Device1UpdateRequestDto requestDto) {
        return device1Service.update(id, requestDto);
    }

    //삭제
    @DeleteMapping("/api/v1/device1/{id}")
    public Long delete(@PathVariable Long id) {
        device1Service.delete(id);
        return id;
    }

    //조회
    @GetMapping("/api/v1/device1/{id}")
    public Device1ResponseDto findById(@PathVariable Long id) {
        return device1Service.findById(id);
    }

    @GetMapping("/api/v1/device1/list")
    public List<Device1ListResponseDto> findAll() {
        return device1Service.findAllDesc();
    }
}
