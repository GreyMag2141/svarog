package com.example.svarog.service.impl;

import com.example.svarog.entity.Prisoner;
import com.example.svarog.repository.PrisonerRepository;
import com.example.svarog.repository.QuestionnaireRepository;
import com.example.svarog.service.PrisonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PrisonerServiceImpl implements PrisonerService {

    private final PrisonerRepository prisonerRepository;
    private final QuestionnaireRepository questionnaireRepository;

    @Override
    public UUID CreateOrUpdatePrisoner(Prisoner prisoner) {
        UUID id = prisonerRepository.save(prisoner).getId();
        prisoner.getQuestionnaires().forEach(e -> {
            e.setPrisoner(prisoner);
            questionnaireRepository.save(e);
        });
        return id;
    }

    @Override
    public Optional<Prisoner> findById(UUID id) {
        return prisonerRepository.findById(id);
    }

    @Override
    public List<Prisoner> findAll() {
        return prisonerRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        prisonerRepository.deleteById(id);
    }
}
