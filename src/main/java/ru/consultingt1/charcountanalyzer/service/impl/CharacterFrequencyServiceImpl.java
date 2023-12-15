package ru.consultingt1.charcountanalyzer.service.impl;

import org.springframework.stereotype.Service;
import ru.consultingt1.charcountanalyzer.aop.annotation.Loggable;
import ru.consultingt1.charcountanalyzer.dto.FrequencyRequestDto;
import ru.consultingt1.charcountanalyzer.dto.FrequencyResponseDto;
import ru.consultingt1.charcountanalyzer.service.CharacterFrequencyService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс представляет собой реализацию интерфейса CharacterFrequencyService
 * и предоставляет метод для вычисления частоты символов в заданной строке
 */
@Service
@Loggable
public class CharacterFrequencyServiceImpl implements CharacterFrequencyService {

    /**
     * Метод вычисляет частоту символов в заданной строке и возвращает результат в виде объекта
     *
     * @param requestDto {@link FrequencyRequestDto}
     * @return {@link FrequencyResponseDto}
     */
    @Override
    public FrequencyResponseDto calculateCharacterFrequency(FrequencyRequestDto requestDto) {
        String inputString = requestDto.getInputString();
        Map<Character, Integer> map = new HashMap<>();

        for (char currentChar : inputString.toCharArray()) {
            map.merge(currentChar, 1, Integer::sum);
        }

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return new FrequencyResponseDto(sortedMap);
    }
}
