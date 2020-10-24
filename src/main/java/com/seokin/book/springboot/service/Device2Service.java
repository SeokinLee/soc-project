package com.seokin.book.springboot.service;

import com.seokin.book.springboot.domain.device2.Device2;
import com.seokin.book.springboot.domain.device2.Device2Repository;
import com.seokin.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Device2Service {
    private final Device2Repository device2Repository;

    //등록
    @Transactional
    public Long save(Device2SaveRequestDto requestDto) {
        return device2Repository.save(requestDto.toEntity()).getId();
    }

    //수정
    @Transactional
    public Long update(Long id, Device2UpdateRequestDto requestDto) {
        Device2 device2 = device2Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        device2.update(requestDto.getLogtime(), requestDto.getLoadage());

        return id;
    }

    //삭제
    @Transactional
    public void delete (Long id) {
        Device2 device2 = device2Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        device2Repository.delete(device2);
    }

    //조회
    @Transactional(readOnly = true)
    public Device2ResponseDto findById(Long id) {
        Device2 entity = device2Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new Device2ResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<Device2ListResponseDto> findAllDesc() {
        return device2Repository.findAllDesc().stream()
                .map(Device2ListResponseDto::new)
                .collect(Collectors.toList());
    }
}