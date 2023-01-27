package ru.skypro.posttracking.dto;

import lombok.Data;
import ru.skypro.posttracking.model.MailType;

@Data
public class MailingDto {

    private Long id;
    private MailType mailType;
    private String zipCode;
    private String address;
    private String recipientName;
}
