package com.platzi.play.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.exception.MovieAlreadyExistsException;
import com.platzi.play.domain.repository.MovieRepository;
import com.platzi.play.persistence.crud.CrudMovieEntity;
import com.platzi.play.persistence.entity.MovieEntity;
import com.platzi.play.persistence.mapper.MovieMapper;

@Repository
public class MovieEntityRepository  implements MovieRepository{

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;


    public MovieEntityRepository(CrudMovieEntity crudMovieEntity,
        MovieMapper movieMapper) {
            this.crudMovieEntity = crudMovieEntity;
            this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(Long id) {
        MovieEntity movieEntity = crudMovieEntity.findById(id).orElse(null);
        return movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto entity) {

        if (crudMovieEntity.findFirstByTitulo(entity.title()) != null) {
            throw new MovieAlreadyExistsException(entity.title());
        }

        MovieEntity movieEntity = movieMapper.toEntity(entity);
        movieEntity.setEstado("D");
        return movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto entity) {
        MovieEntity movieEntity = crudMovieEntity.findById(id).orElse(null);
        if (movieEntity == null) {
            return null;
        }
        // Assuming UpdateMovieDto has getters for fields to update
        movieEntity.setTitulo(entity.title());
        movieEntity.setFechaEstreno(entity.releaseDate());
        movieEntity.setClasificacion(BigDecimal.valueOf(entity.rating()));
        // Add other fields as needed
        //opcional
        //movieMapper.updateFromDto(entity, movieEntity);
        
        MovieEntity updatedEntity = crudMovieEntity.save(movieEntity);
        
        return movieMapper.toDto(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        crudMovieEntity.deleteById(id);
    }

    
    

}
