package ru.skypro.posttracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.posttracking.model.Mailing;

public interface MailingRepository extends JpaRepository<Mailing, Long> {
}
