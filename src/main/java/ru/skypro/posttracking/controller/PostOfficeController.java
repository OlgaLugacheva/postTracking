package ru.skypro.posttracking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.posttracking.dto.CreatePostOfficeDto;
import ru.skypro.posttracking.dto.PostOfficeDto;
import ru.skypro.posttracking.mappers.PostOfficeMapper;
import ru.skypro.posttracking.service.PostOfficeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/postoffice")
@RequiredArgsConstructor
public class PostOfficeController {

    private final PostOfficeService postOfficeService;
    private final PostOfficeMapper postOfficeMapper;

    @PostMapping
    public ResponseEntity<PostOfficeDto> addOffice(@Valid @RequestBody CreatePostOfficeDto createPostOfficeDto) {
        return ResponseEntity.ok(postOfficeMapper.toPostOfficeDto(postOfficeService.createPostOffice(createPostOfficeDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostOfficeDto> getOffice(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(postOfficeMapper.toPostOfficeDto(postOfficeService.getPostOffice(id)));
    }

}
