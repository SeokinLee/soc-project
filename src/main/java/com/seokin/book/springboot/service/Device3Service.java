package com.seokin.book.springboot.service;


import com.seokin.book.springboot.domain.device3.Device3Repository;
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

    @Transactional(readOnly = true)
    public List<Device3ListResponseDto> findAllDesc() {
        return device3Repository.findAllDesc().stream()
                .map(Device3ListResponseDto::new)
                .collect(Collectors.toList());
    }
}
