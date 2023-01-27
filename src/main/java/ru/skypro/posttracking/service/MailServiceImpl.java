package ru.skypro.posttracking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.skypro.posttracking.dto.CreateMailingDto;
import ru.skypro.posttracking.dto.StateDto;
import ru.skypro.posttracking.mappers.MailingMapper;
import ru.skypro.posttracking.mappers.StateMapper;
import ru.skypro.posttracking.dto.UpdateStateDto;
import ru.skypro.posttracking.model.MailStatus;
import ru.skypro.posttracking.model.Mailing;
import ru.skypro.posttracking.model.PostOffice;
import ru.skypro.posttracking.model.State;
import ru.skypro.posttracking.repository.MailingRepository;
import ru.skypro.posttracking.repository.PostOfficeRepository;
import ru.skypro.posttracking.repository.StateRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailingMapper mailingMapper;
    private final StateMapper stateMapper;
    private final MailingRepository mailingRepository;
    private final StateRepository stateRepository;
    private final PostOfficeRepository postOfficeRepository;

    @Override
    public Mailing createMailing(CreateMailingDto createMailingDto) {


        PostOffice postOffice = postOfficeRepository
                .findById(createMailingDto.getPostOfficeId())
                .orElseThrow(() -> new NotFoundException("Не найдено почтовое отделение по id" + createMailingDto.getPostOfficeId()));
        Mailing mailing = mailingMapper.toMailing(createMailingDto);
        mailing.setStates(List.of(State.builder().status(MailStatus.REGISTERED).postOffice(postOffice).build()));
        return mailingRepository.save(mailing);
    }

    @Override
    public Mailing updateMailing(UpdateStateDto updateStateDto) {
        Mailing mailing = mailingRepository
                .findById(updateStateDto.getMailId())
                .orElseThrow(() -> new NotFoundException("Отправление с id" + updateStateDto.getMailId() + " не существует"));
        Collection<State> states = mailing.getStates();
        states.add(stateMapper.toState(updateStateDto));
        mailing.setStates(states);
        return mailingRepository.save(mailing);
    }

    @Override
    public Mailing getMailing(Long id) {
        return mailingRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Отправление с id" + id + " не существует"));
    }

    @Override
    public Collection<State> getMailingState(Long id) {
        return stateRepository.findByMailingId(id);
    }
}
