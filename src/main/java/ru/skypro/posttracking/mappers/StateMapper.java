package ru.skypro.posttracking.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.posttracking.dto.StateDto;
import ru.skypro.posttracking.dto.UpdateStateDto;
import ru.skypro.posttracking.model.State;

@Mapper(componentModel = "spring")
public interface StateMapper {

    @Mapping(target = "mailing.id", source = "mailId")
    @Mapping(target = "postOffice.id", source = "postOfficeId")
    State toState(UpdateStateDto updateStateDto);


    StateDto toStateDto(State state);

}
