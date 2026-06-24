package com.eskcti.moderation_service.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eskcti.moderation_service.api.model.ModerationInput;
import com.eskcti.moderation_service.api.model.ModerationOutput;
import com.eskcti.moderation_service.api.service.ModerationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {
    private final ModerationService moderationService;

    @PostMapping
    public ModerationOutput moderate(@RequestBody ModerationInput input) {
        return moderationService.moderate(input);
    }
}
