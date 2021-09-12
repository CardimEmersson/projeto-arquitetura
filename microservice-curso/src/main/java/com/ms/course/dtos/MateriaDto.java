package com.ms.course.dtos;

import com.ms.course.models.RequisitoModel;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MateriaDto {

    @NotBlank
    private String nomeMateria;
    @NotNull
    private int cargaHoraria;
    @NotBlank
    private String descricaoMateria;
    @NotEmpty
    private List<RequisitoDto> listaRequisitos;
    @NotNull
    private int creditos;
    @NotBlank
    private String ementa;
}
