package com.seokin.book.springboot.service;


import com.seokin.book.springboot.domain.device1.Device1;
import com.seokin.book.springboot.domain.device1.Device1Repository;
import com.seokin.book.springboot.web.dto.Device1ListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Device1Service {
    private final Device1Repository device1Repository;

    @Transactional(readOnly = true)
    public List<Device1ListResponseDto> findAllDesc() {
        return device1Repository.findAllDesc().stream()
                .map(Device1ListResponseDto::new)
                .collect(Collectors.toList());
    }
}
