package com.platzi.play.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.repository.MovieRepository;

import dev.langchain4j.agent.tool.Tool;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las peliculas que existan dentro de la plataforma")
    public List<MovieDto> getAll() {
        return movieRepository.getAll();
    }

    public MovieDto getById(Long id) {
        return movieRepository.getById(id);
    }

    public MovieDto save(MovieDto entity) {
        
        return movieRepository.save(entity);
    }

    public MovieDto update(Long id, UpdateMovieDto entity) {
       return movieRepository.update(id,entity);
    }

    public void deleteById(Long id) {
       movieRepository.deleteById(id);
    }

}
