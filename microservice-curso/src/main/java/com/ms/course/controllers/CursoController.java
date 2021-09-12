package com.ms.course.controllers;

import com.ms.course.dtos.CursoDto;
import com.ms.course.dtos.RequisitoDto;
import com.ms.course.models.CursoModel;
import com.ms.course.models.MateriaModel;
import com.ms.course.models.RequisitoModel;
import com.ms.course.services.CursoService;
import com.ms.course.services.MateriaService;
import com.ms.course.services.RequisitoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//é um controller que vai utilizar de API's REST
@RestController
public class CursoController {
    @Autowired
    RequisitoService requisitoService;

    @Autowired
    MateriaService materiaService;

    @Autowired
    CursoService cursoService;

    /*
        Método abaixo.. Funções:
        - Receber o DTO de entrada
        - fazer a validação
        - passar do dto para o model
        - para salvar-mos o dto

        sempre que um usuário/serviço enviar uma requisição via POST para enviando-curso
        o método enviandoCurso será disparado.
    */
    @PostMapping("/enviando-curso")
    //recebendo como parâmentros o CursoDto
    //para que as validações do DTO tenham efeito, é necessário usar o @Valid
    public ResponseEntity<CursoModel> enviandoCurso(@RequestBody @Valid CursoDto cursoDto) {
        CursoModel cursoModel = new CursoModel();
        BeanUtils.copyProperties(cursoDto, cursoModel);

        List<MateriaModel> materias = new ArrayList();
        for(int i = 0; i < cursoDto.getListaMaterias().size(); i++) {
            MateriaModel materiaModel = new MateriaModel();
            BeanUtils.copyProperties(cursoDto.getListaMaterias().get(i), materiaModel);

            List<RequisitoModel> requisitos = new ArrayList();
            for(int j = 0; j < cursoDto.getListaMaterias().get(i).getListaRequisitos().size(); j++) {
                RequisitoModel requisitoModel = new RequisitoModel();

                BeanUtils.copyProperties(cursoDto.getListaMaterias().get(i).getListaRequisitos().get(j), requisitoModel);
                requisitoService.enviarRequisito(requisitoModel);
                requisitos.add(requisitoModel);
            }
            materiaModel.setListaRequisitos(requisitos);

            materiaService.enviarMateria(materiaModel);
            materias.add(materiaModel);
        }
        cursoModel.setListaMaterias(materias);
        cursoService.enviarCurso(cursoModel);

        return new ResponseEntity<>(cursoModel, HttpStatus.CREATED);
    }
}
