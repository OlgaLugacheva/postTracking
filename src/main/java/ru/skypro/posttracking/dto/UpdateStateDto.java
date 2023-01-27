package ru.skypro.posttracking.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.skypro.posttracking.model.MailStatus;
import ru.skypro.posttracking.model.MailType;

import javax.validation.constraints.NotNull;

@Data
public class UpdateStateDto {

    @NotNull(message = "Идентификатор отправления является обязательным полем")
    private Long mailId;
    @NotNull(message = "Укажите статус отправления")
    private MailStatus mailStatus;
    @NotNull(message = "Укажите идентификатор почтового отделения")
    private Long postOfficeId;

}
