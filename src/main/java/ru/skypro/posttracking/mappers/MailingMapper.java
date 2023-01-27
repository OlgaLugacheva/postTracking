package ru.skypro.posttracking.mappers;

import org.mapstruct.Mapper;
import ru.skypro.posttracking.dto.CreateMailingDto;
import ru.skypro.posttracking.dto.MailingDto;
import ru.skypro.posttracking.model.Mailing;

@Mapper(componentModel = "spring")
public interface MailingMapper {

    Mailing toMailing(CreateMailingDto createMailingDto);

    MailingDto toMailingDto(Mailing mailing);

}
