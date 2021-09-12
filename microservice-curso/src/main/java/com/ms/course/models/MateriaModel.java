package com.ms.course.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TB_MATERIA")
public class MateriaModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoMateria;
    private String nomeMateria;
    private int cargaHoraria;
    @Column(columnDefinition = "TEXT")
    private String descricaoMateria;
    @OneToMany
    private List<RequisitoModel> listaRequisitos;
    private int creditos;
    private String ementa;
}
