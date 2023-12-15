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

}
