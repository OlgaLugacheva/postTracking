package ru.skypro.posttracking.dto;

import lombok.Data;
import ru.skypro.posttracking.model.MailType;

import javax.validation.constraints.NotNull;

@Data
public class CreateMailingDto {
    @NotNull(message = "Тип отправления является обязательным")
    private MailType mailType;
    @NotNull(message = "Индекс получателя является обязательным")
    private String zipCode;
    @NotNull(message = "Адрес получателя является обязательным")
    private String address;
    @NotNull(message = "Имя получателя является обязательным")
    private String recipientName;
    @NotNull(message = "Идентификатор почтового отделения обязателен")
    private Long postOfficeId;


}
