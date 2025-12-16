package com.platzi.play.persistence.mapper;

import org.mapstruct.Named;

import com.platzi.play.domain.Genre;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genre) {
        switch (genre) {
            case null:
                return null;
            case "ACCION":
                return Genre.ACTION;
            case "COMEDIA":
                return Genre.COMEDY;
            case "DRAMA":
                return Genre.DRAMA;
            case "ANIMADA":
                return Genre.ANIMATED;
            case "TERROR":
                return Genre.HORROR;
            case "CIENCIA_FICCION":
                return Genre.SCI_FI;
            default:
                return null;
        
        }
    }

    @Named("genreToString")
    public static String gnreToString(Genre genre){

        switch (genre) {
            case ACTION:
                return "ACCION";
            case COMEDY:
                return "COMEDIA";
            case DRAMA:
                return "DRAMA";
            case ANIMATED:
                return "ANIMADA";
            case HORROR:
                return "TERROR";
            case SCI_FI:
                return "CIENCIA_FICCION";
            default:
                return null;
        }
    }
}
