package com.ms.course.dtos;

import com.ms.course.models.MateriaModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

//class que receberá as informações do método POST
@Data
public class CursoDto {
    //quando recebermos o objeto a biblioteca fará a validação
    //caso receba vazio, ele já envia uma bad request pro usuário
    @NotBlank
    private String nomeCurso;
    @NotNull
    private int qtdPeriodo;
    @NotNull
    private int cargaHoraria;
    @NotBlank
    private String descricaoCurso;
    @NotEmpty
    private List<MateriaDto> listaMaterias;
}
