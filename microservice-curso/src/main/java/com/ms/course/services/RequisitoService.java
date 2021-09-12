package com.ms.course.services;

import com.ms.course.models.MateriaModel;
import com.ms.course.models.RequisitoModel;
import com.ms.course.repositories.RequisitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisitoService {
    @Autowired
    RequisitoRepository requisitoRepository;

    public RequisitoModel enviarRequisito(RequisitoModel requisitoModel) {
        return requisitoRepository.save(requisitoModel);
    }
}
