package com.seokin.book.springboot.service;
import com.seokin.book.springboot.domain.device2.Device2;

import com.seokin.book.springboot.domain.device2.Device2Repository;
import com.seokin.book.springboot.web.dto.Device2ListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Device2Service {
    private final Device2Repository device2Repository;

    @Transactional(readOnly = true)
    public List<Device2ListResponseDto> findAllDesc() {
        return device2Repository.findAllDesc().stream()
                .map(Device2ListResponseDto::new)
                .collect(Collectors.toList());
    }
}
