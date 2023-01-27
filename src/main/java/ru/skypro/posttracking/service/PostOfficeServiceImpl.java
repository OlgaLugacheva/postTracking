package ru.skypro.posttracking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.skypro.posttracking.dto.CreatePostOfficeDto;
import ru.skypro.posttracking.mappers.PostOfficeMapper;
import ru.skypro.posttracking.model.PostOffice;
import ru.skypro.posttracking.repository.PostOfficeRepository;

@Service
@RequiredArgsConstructor
public class PostOfficeServiceImpl implements PostOfficeService {

    private final PostOfficeRepository postOfficeRepository;
    private final PostOfficeMapper postOfficeMapper;

    @Override
    public PostOffice createPostOffice(CreatePostOfficeDto createPostOfficeDto) {
        return postOfficeRepository.save(postOfficeMapper.toPostOffice(createPostOfficeDto));
    }

    @Override
    public PostOffice getPostOffice(Long id) {
        return postOfficeRepository.findById(id).orElseThrow(() -> new NotFoundException("Почтовое отделение не найдено" + id));
    }
}
