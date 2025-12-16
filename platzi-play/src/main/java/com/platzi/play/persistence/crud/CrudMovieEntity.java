package com.platzi.play.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.platzi.play.persistence.entity.MovieEntity;

@Repository
public interface CrudMovieEntity extends CrudRepository<MovieEntity,Long>{

    MovieEntity findFirstByTitulo(String titulo);

}
