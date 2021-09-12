package com.ms.course.repositories;

import com.ms.course.models.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;

//JPARepository proporciona usar métodos prontos
//como findAll, FindById, etc...
public interface CursoRepository extends JpaRepository<CursoModel, Long> {
}
