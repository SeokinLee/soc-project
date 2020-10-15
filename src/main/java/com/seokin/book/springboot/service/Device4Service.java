package com.seokin.book.springboot.service;


import com.seokin.book.springboot.domain.device4.Device4Repository;
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

    @Transactional(readOnly = true)
    public List<Device4ListResponseDto> findAllDesc() {
        return device4Repository.findAllDesc().stream()
                .map(Device4ListResponseDto::new)
                .collect(Collectors.toList());
    }
}
