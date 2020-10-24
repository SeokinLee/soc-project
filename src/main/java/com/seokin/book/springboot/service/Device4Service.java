package com.seokin.book.springboot.service;


import com.seokin.book.springboot.domain.device4.Device4;
import com.seokin.book.springboot.domain.device4.Device4Repository;
import com.seokin.book.springboot.web.dto.*;
import com.seokin.book.springboot.web.dto.Device4ListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Device4Service {
    private final Device4Repository device4Repository;

    //등록
    @Transactional
    public Long save(Device4SaveRequestDto requestDto) {
        return device4Repository.save(requestDto.toEntity()).getId();
    }

    //수정
    @Transactional
    public Long update(Long id, Device4UpdateRequestDto requestDto) {
        Device4 device4 = device4Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        device4.update(requestDto.getLogtime(), requestDto.getLoadage());

        return id;
    }

    //삭제
    @Transactional
    public void delete (Long id) {
        Device4 device4 = device4Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        device4Repository.delete(device4);
    }

    //조회
    @Transactional(readOnly = true)
    public Device4ResponseDto findById(Long id) {
        Device4 entity = device4Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new Device4ResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<Device4ListResponseDto> findAllDesc() {
        return device4Repository.findAllDesc().stream()
                .map(Device4ListResponseDto::new)
                .collect(Collectors.toList());
    }
}