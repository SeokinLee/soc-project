package com.seokin.book.springboot.service;


import com.seokin.book.springboot.domain.device3.Device3;
import com.seokin.book.springboot.domain.device3.Device3Repository;
import com.seokin.book.springboot.web.dto.*;
import com.seokin.book.springboot.web.dto.Device3ListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Device3Service {
    private final Device3Repository device3Repository;

    //등록
    @Transactional
    public Long save(Device3SaveRequestDto requestDto) {
        return device3Repository.save(requestDto.toEntity()).getId();
    }

    //수정
    @Transactional
    public Long update(Long id, Device3UpdateRequestDto requestDto) {
        Device3 device3 = device3Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        device3.update(requestDto.getLogtime(), requestDto.getLoadage());

        return id;
    }

    //삭제
    @Transactional
    public void delete (Long id) {
        Device3 device3 = device3Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        device3Repository.delete(device3);
    }

    //조회
    @Transactional(readOnly = true)
    public Device3ResponseDto findById(Long id) {
        Device3 entity = device3Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new Device3ResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<Device3ListResponseDto> findAllDesc() {
        return device3Repository.findAllDesc().stream()
                .map(Device3ListResponseDto::new)
                .collect(Collectors.toList());
    }
}