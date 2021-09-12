package com.ms.course.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_REQUISITOS")
public class RequisitoModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoRequisito;
    @Column(columnDefinition = "TEXT")
    private String descricaoRequisito;
}
