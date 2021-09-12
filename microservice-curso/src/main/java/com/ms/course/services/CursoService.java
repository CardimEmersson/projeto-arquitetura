package com.ms.course.services;

//camada intermediaria entre o repository e o controller

import com.ms.course.enums.StatusCurso;
import com.ms.course.models.CursoModel;
import com.ms.course.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CursoService {
    /*
    como eu vou precisar de um ponto de injecao de repository pra conseguir criar os métodos
    pra fazer a persistencia com o banco, vamos inserir o Autowired
    */
    @Autowired
    CursoRepository cursoRepository;

    public CursoModel enviarCurso(CursoModel cursoModel) {
        cursoModel.setDataEnvioCurso(LocalDateTime.now());
        cursoModel.setStatusCurso(StatusCurso.SENT);

        return cursoRepository.save(cursoModel);
    }
}
