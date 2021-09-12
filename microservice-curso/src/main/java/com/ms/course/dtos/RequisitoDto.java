package com.ms.course.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequisitoDto {
    @NotBlank
    private String descricaoRequisito;
}
