package com.seokin.book.springboot.service;

import com.seokin.book.springboot.domain.device1.Device1;
import com.seokin.book.springboot.domain.device1.Device1Repository;
import com.seokin.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Device1Service {
    private final Device1Repository device1Repository;

    //등록
    @Transactional
    public Long save(Device1SaveRequestDto requestDto) {
        return device1Repository.save(requestDto.toEntity()).getId();
    }

    //수정
    @Transactional
    public Long update(Long id, Device1UpdateRequestDto requestDto) {
        Device1 device1 = device1Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        device1.update(requestDto.getLogtime(), requestDto.getLoadage());

        return id;
    }

    //삭제
    @Transactional
    public void delete (Long id) {
        Device1 device1 = device1Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        device1Repository.delete(device1);
    }

    //조회
    @Transactional(readOnly = true)
    public Device1ResponseDto findById(Long id) {
        Device1 entity = device1Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new Device1ResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<Device1ListResponseDto> findAllDesc() {
        return device1Repository.findAllDesc().stream()
                .map(Device1ListResponseDto::new)
                .collect(Collectors.toList());
    }
}
