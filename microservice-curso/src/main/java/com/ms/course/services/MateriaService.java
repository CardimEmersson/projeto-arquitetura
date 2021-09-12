package com.ms.course.services;

import com.ms.course.models.MateriaModel;
import com.ms.course.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    MateriaRepository materiaRepository;

    public MateriaModel enviarMateria(MateriaModel materiaModel) {
        return materiaRepository.save(materiaModel);
    }
}
