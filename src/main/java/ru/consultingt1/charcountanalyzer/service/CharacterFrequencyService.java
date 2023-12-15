package ru.consultingt1.charcountanalyzer.service;

import ru.consultingt1.charcountanalyzer.dto.FrequencyRequestDto;
import ru.consultingt1.charcountanalyzer.dto.FrequencyResponseDto;

/**
 * Интерфейс  определяет контракт для сервиса,
 * который вычисляет частоты символов в заданной строке
 */
public interface CharacterFrequencyService {

    /**
     * Метод вычисляет частоту символов в заданной строке и возвращает результат в виде объекта
     *
     * @param requestDto {@link FrequencyRequestDto}
     * @return {@link FrequencyResponseDto}
     */
    FrequencyResponseDto calculateCharacterFrequency(FrequencyRequestDto requestDto);
}
