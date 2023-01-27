package ru.skypro.posttracking.mappers;

import org.mapstruct.Mapper;
import ru.skypro.posttracking.dto.CreatePostOfficeDto;
import ru.skypro.posttracking.dto.PostOfficeDto;
import ru.skypro.posttracking.model.PostOffice;

@Mapper(componentModel = "spring")
public interface PostOfficeMapper {

    PostOffice toPostOffice(CreatePostOfficeDto createPostOfficeDto);

    PostOfficeDto toPostOfficeDto(PostOffice postOffice);

}
