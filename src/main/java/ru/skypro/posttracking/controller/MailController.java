package ru.skypro.posttracking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.skypro.posttracking.dto.CreateMailingDto;
import ru.skypro.posttracking.dto.MailingDto;
import ru.skypro.posttracking.dto.StateDto;
import ru.skypro.posttracking.dto.UpdateStateDto;
import ru.skypro.posttracking.mappers.MailingMapper;
import ru.skypro.posttracking.mappers.StateMapper;
import ru.skypro.posttracking.service.MailService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    private final MailingMapper mailingMapper;
    private final StateMapper stateMapper;

    @PostMapping
    public ResponseEntity<MailingDto> addMail(@Valid @RequestBody CreateMailingDto createMailingDto) {
         return ResponseEntity.ok(mailingMapper.toMailingDto(mailService.createMailing(createMailingDto)));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<MailingDto> editMail(@Valid @RequestBody UpdateStateDto updateMailingDto) {
        return ResponseEntity.ok(mailingMapper.toMailingDto(mailService.updateMailing(updateMailingDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MailingDto> getMail(@PathVariable Long id) {
        return ResponseEntity.ok(mailingMapper.toMailingDto(mailService.getMailing(id)));
    }

    @GetMapping("/{id}/status")
    public Collection<StateDto> getMailStates(@PathVariable Long id) {
        return mailService.getMailingState(id).stream().map(stateMapper::toStateDto).collect(Collectors.toList());
    }

}
