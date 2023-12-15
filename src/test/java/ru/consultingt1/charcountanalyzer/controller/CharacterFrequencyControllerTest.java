package ru.consultingt1.charcountanalyzer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.consultingt1.charcountanalyzer.service.CharacterFrequencyService;
import ru.consultingt1.charcountanalyzer.controller.advice.ExceptionHandlerAdvice;
import ru.consultingt1.charcountanalyzer.dto.FrequencyRequestDto;
import ru.consultingt1.charcountanalyzer.dto.FrequencyResponseDto;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CharacterFrequencyControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CharacterFrequencyService frequencyService;

    @InjectMocks
    private CharacterFrequencyController frequencyController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(frequencyController)
                .setControllerAdvice(new ExceptionHandlerAdvice())
                .build();
    }

    @Test
    void calculateFrequencyTest() throws Exception {
        FrequencyRequestDto requestDto = new FrequencyRequestDto("test");
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(requestDto);

        when(frequencyService.calculateCharacterFrequency(requestDto))
                .thenReturn(new FrequencyResponseDto(Map.of('t', 2, 'e', 1, 's', 1)));
        mockMvc.perform(post("/calculateFrequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.frequency.t").value(2))
                .andExpect(jsonPath("$.frequency.e").value(1))
                .andExpect(jsonPath("$.frequency.s").value(1));
    }

    @Test
    void calculateFrequencyValidationTest() throws Exception {
        FrequencyRequestDto requestDto = new FrequencyRequestDto(""); // Предположим, это невалидный запрос
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(post("/calculateFrequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.inputString").value("Input string must not be blank"));
    }

    @Test
    void calculateFrequencyInvalidInputTest() throws Exception {
        String longString = "a".repeat(51);
        FrequencyRequestDto requestDto = new FrequencyRequestDto(longString);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(post("/calculateFrequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.inputString").value("Input string must be less than 50 characters"));
    }
}
