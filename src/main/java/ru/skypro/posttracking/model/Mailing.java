package ru.skypro.posttracking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Mailing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private MailType mailType;
    private String zipCode;
    private String address;
    private String recipientName;
    @OneToMany(targetEntity = State.class, cascade=CascadeType.ALL)
    @JoinColumn(name = "mail_id",nullable = false)
    @JsonManagedReference
    private Collection<State> states;

}
