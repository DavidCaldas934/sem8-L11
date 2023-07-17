package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cursos" , path = "cursos")
public interface CursoRepository extends PagingAndSortingRepository<Curso, Integer>,CrudRepository<Curso, Integer> {
    
    List<Curso> findByNombre(@Param("nombre") String nombre);
}
