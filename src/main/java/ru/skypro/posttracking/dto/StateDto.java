package ru.skypro.posttracking.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import ru.skypro.posttracking.model.MailStatus;
import ru.skypro.posttracking.model.Mailing;
import ru.skypro.posttracking.model.PostOffice;

import javax.persistence.*;
@Data
public class StateDto {
    private Long id;
    private MailStatus status;
    private Long postOfficeId;
}
