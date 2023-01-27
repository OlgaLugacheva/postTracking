package ru.skypro.posttracking.service;

import ru.skypro.posttracking.dto.CreateMailingDto;
import ru.skypro.posttracking.dto.UpdateStateDto;
import ru.skypro.posttracking.model.Mailing;
import ru.skypro.posttracking.model.State;

import java.util.Collection;

public interface MailService {

    Mailing createMailing(CreateMailingDto createMailingDto);

    Mailing updateMailing(UpdateStateDto updateMailingDto);

    Mailing getMailing(Long id);

    Collection<State> getMailingState(Long id);

}
