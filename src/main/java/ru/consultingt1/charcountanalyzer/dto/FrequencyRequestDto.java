package ru.consultingt1.charcountanalyzer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс DTO, используемый для запросов
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrequencyRequestDto {
    @NotBlank(message = "Input string must not be blank")
    @Size(max = 30, message = "Input string must be less than 50 characters")
    private String inputString;
}
