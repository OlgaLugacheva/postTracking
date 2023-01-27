package ru.skypro.posttracking.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class PostOfficeDto {
    private Long id;
    private String name;
    private String postCode;
    private String address;

}
