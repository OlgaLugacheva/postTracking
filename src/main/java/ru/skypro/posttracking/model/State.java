package ru.skypro.posttracking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "mail_id", nullable = false,  insertable=false, updatable=false)
    @JsonBackReference
    private Mailing mailing;
    @Enumerated(EnumType.ORDINAL)
    private MailStatus status;
    @OneToOne
    @JoinColumn(name = "post_office_id")
    private PostOffice postOffice;

}
