package com.eskcti.moderation_service.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eskcti.moderation_service.api.model.ModerationInput;
import com.eskcti.moderation_service.api.model.ModerationOutput;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ModerationService {

    private static final List<String> FORBIDDEN_WORDS = List.of("ódio", "xingamento");

    public ModerationOutput moderate(ModerationInput input) {
        log.info("Moderating comment {}", input.getCommentId());

        String normalizedText = input.getText().toLowerCase();

        for (String forbiddenWord : FORBIDDEN_WORDS) {
            if (normalizedText.contains(forbiddenWord.toLowerCase())) {
                String reason = "Text contains forbidden word: " + forbiddenWord;
                log.info("Comment {} rejected: {}", input.getCommentId(), reason);

                return ModerationOutput.builder()
                    .approved(false)
                    .reason(reason)
                    .build();
            }
        }

        log.info("Comment {} approved", input.getCommentId());

        return ModerationOutput.builder()
            .approved(true)
            .reason("Comment approved")
            .build();
    }
}
