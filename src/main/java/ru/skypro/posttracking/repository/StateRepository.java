package ru.skypro.posttracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.posttracking.model.State;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByMailingId(Long mailId);

}
