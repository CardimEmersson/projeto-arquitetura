package com.ms.course.models;

import com.ms.course.enums.StatusCurso;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

//com o lombok não preciso utilizar os métodos get/set
@Data
//definindo essa classe como uma entidade
@Entity
//passando o nome da tabela que vai ser gerado no banco com base na entidade
@Table(name = "TB_COURSE")
public class CursoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoCurso;
    private String nomeCurso;
    private int qtdPeriodo;
    private int cargaHoraria;
    @Column(columnDefinition = "TEXT")
    private String descricaoCurso;
    @OneToMany
    private List<MateriaModel> listaMaterias;
    private LocalDateTime dataEnvioCurso;
    private StatusCurso statusCurso;
}
