package com.seokin.book.springboot.web;

import com.seokin.book.springboot.service.Device2Service;
import com.seokin.book.springboot.web.dto.Device2ListResponseDto;
import com.seokin.book.springboot.web.dto.Device2ResponseDto;
import com.seokin.book.springboot.web.dto.Device2SaveRequestDto;
import com.seokin.book.springboot.web.dto.Device2UpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Device2ApiController {

    private Device2Service device2Service;

    //등록
    @PostMapping("/api/v1/device2")
    public Long save(@RequestBody Device2SaveRequestDto requestDto) {
        return device2Service.save(requestDto);
    }

    //수정
    @PutMapping("/api/v1/device2/{id}")
    public Long update(@PathVariable Long id, @RequestBody Device2UpdateRequestDto requestDto) {
        return device2Service.update(id, requestDto);
    }

    //삭제
    @DeleteMapping("/api/v1/device2/{id}")
    public Long delete(@PathVariable Long id) {
        device2Service.delete(id);
        return id;
    }

    //조회
    @GetMapping("/api/v1/device2/{id}")
    public Device2ResponseDto findById(@PathVariable Long id) {
        return device2Service.findById(id);
    }

    @GetMapping("/api/v1/device2/list")
    public List<Device2ListResponseDto> findAll() {
        return device2Service.findAllDesc();
    }
}
