package com.example.svarog.controllers;

import com.example.svarog.entity.Message;
import com.example.svarog.repository.MessageRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("message")
@Api(tags = "MainController", description = "API for svarog")
public class MainController {

    private final MessageRepository messageRepository;

    @GetMapping
    public List<Message> list() {
        return messageRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Message> getById(@PathVariable long id) {
        return messageRepository.findById(id);
    }

    @PostMapping
    public long createOrUpdate(@RequestBody Message message) {
        return messageRepository.save(message).getId();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        messageRepository.deleteById(id);
    }
}

