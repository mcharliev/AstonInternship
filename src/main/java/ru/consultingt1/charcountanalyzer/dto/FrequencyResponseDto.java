package ru.consultingt1.charcountanalyzer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Класс DTO, используемый для отеветов
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrequencyResponseDto {

    private Map<Character, Integer> frequency;
}
