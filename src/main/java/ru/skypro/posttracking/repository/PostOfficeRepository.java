package ru.skypro.posttracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.posttracking.model.Mailing;
import ru.skypro.posttracking.model.PostOffice;
import ru.skypro.posttracking.model.State;

import java.util.List;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {

}
