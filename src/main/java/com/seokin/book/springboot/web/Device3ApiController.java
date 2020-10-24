package com.seokin.book.springboot.web;

import com.seokin.book.springboot.service.Device3Service;
import com.seokin.book.springboot.web.dto.Device3ListResponseDto;
import com.seokin.book.springboot.web.dto.Device3ResponseDto;
import com.seokin.book.springboot.web.dto.Device3SaveRequestDto;
import com.seokin.book.springboot.web.dto.Device3UpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Device3ApiController {

    private Device3Service device3Service;

    //등록
    @PostMapping("/api/v1/device3")
    public Long save(@RequestBody Device3SaveRequestDto requestDto) {
        return device3Service.save(requestDto);
    }

    //수정
    @PutMapping("/api/v1/device3/{id}")
    public Long update(@PathVariable Long id, @RequestBody Device3UpdateRequestDto requestDto) {
        return device3Service.update(id, requestDto);
    }

    //삭제
    @DeleteMapping("/api/v1/device3/{id}")
    public Long delete(@PathVariable Long id) {
        device3Service.delete(id);
        return id;
    }

    //조회
    @GetMapping("/api/v1/device3/{id}")
    public Device3ResponseDto findById(@PathVariable Long id) {
        return device3Service.findById(id);
    }

    @GetMapping("/api/v1/device3/list")
    public List<Device3ListResponseDto> findAll() {
        return device3Service.findAllDesc();
    }
}
