package com.platzi.play.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.persistence.entity.MovieEntity;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface MovieMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    MovieDto toDto(MovieEntity entity);

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero", qualifiedByName = "genreToString")
    @Mapping(target = "estado", ignore = true)
    MovieEntity toEntity(MovieDto dto);

    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "releaseDate", target = "fechaEstreno")
    @Mapping(source = "rating", target = "clasificacion")
    @Mapping(target = "duracion", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "genero", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateFromDto(UpdateMovieDto dto, @MappingTarget MovieEntity entity);

}
