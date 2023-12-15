package ru.consultingt1.charcountanalyzer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.consultingt1.charcountanalyzer.aop.annotation.Loggable;
import ru.consultingt1.charcountanalyzer.dto.FrequencyRequestDto;
import ru.consultingt1.charcountanalyzer.dto.FrequencyResponseDto;
import ru.consultingt1.charcountanalyzer.service.CharacterFrequencyService;

@RestController
@RequiredArgsConstructor
@Loggable
@Tag(name = "Расчет частоты символов в строке")
public class CharacterFrequencyController {
    private final CharacterFrequencyService frequencyService;

    @PostMapping("/calculateFrequency")
    @Operation(summary = "Расчет частоты символов в строке")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный расчет частоты символов"),
            @ApiResponse(responseCode = "400", description = "Неверные входные данные")
    })
    public ResponseEntity<FrequencyResponseDto> calculateFrequency(@Valid @RequestBody FrequencyRequestDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(frequencyService.calculateCharacterFrequency(request));
    }
}
