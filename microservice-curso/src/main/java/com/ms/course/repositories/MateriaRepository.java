package com.ms.course.repositories;

import com.ms.course.models.MateriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<MateriaModel, Long> {
}
