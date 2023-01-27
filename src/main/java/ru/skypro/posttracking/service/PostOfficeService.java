package ru.skypro.posttracking.service;

import ru.skypro.posttracking.dto.CreatePostOfficeDto;
import ru.skypro.posttracking.model.PostOffice;

public interface PostOfficeService {

    PostOffice createPostOffice(CreatePostOfficeDto createPostOfficeDto);

    PostOffice getPostOffice(Long id);

}
