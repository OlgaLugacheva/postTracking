package ru.skypro.posttracking.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostOfficeDto {
    @NotEmpty(message = "Название не может быть пустым")
    @NotNull(message = "Название обязательное поле")
    private String name;
    @NotEmpty(message = "Индекс не может быть пустым")
    @NotNull(message = "Индекс обязательное поле")
    private String postCode;
    @NotEmpty(message = "Адрес не может быть пустым")
    @NotNull(message = "Адрес обязательное поле")
    private String address;

}
