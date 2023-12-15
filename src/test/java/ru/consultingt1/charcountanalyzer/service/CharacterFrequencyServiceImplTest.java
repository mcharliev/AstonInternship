package ru.consultingt1.charcountanalyzer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.consultingt1.charcountanalyzer.dto.FrequencyRequestDto;
import ru.consultingt1.charcountanalyzer.dto.FrequencyResponseDto;
import ru.consultingt1.charcountanalyzer.service.impl.CharacterFrequencyServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CharacterFrequencyServiceImplTest {

    private CharacterFrequencyService characterFrequencyService;

    @BeforeEach
    void setUp() {
        characterFrequencyService = new CharacterFrequencyServiceImpl();
    }

    @Test
    void calculateCharacterFrequencyTest() {
        FrequencyRequestDto request = new FrequencyRequestDto("aaaaabcccc");
        FrequencyResponseDto response = characterFrequencyService.calculateCharacterFrequency(request);
        assertNotNull(response);

        assertEquals(5, response.getFrequency().getOrDefault('a', 0));
        assertEquals(1, response.getFrequency().getOrDefault('b', 0));
        assertEquals(4, response.getFrequency().getOrDefault('c', 0));
    }
}
