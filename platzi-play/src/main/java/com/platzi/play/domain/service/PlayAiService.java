package com.platzi.play.domain.service;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;


@AiService
public interface PlayAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestion de peliculas {{platform}}.
            Usa menos de 120 caracteres y hazlo con el estilo Platzi.
            """)
    public String generatedGreeting(@V("platform") String platform);


    @SystemMessage("""
        Eres un experto en cine que recomienda peliculas personalizadas según los gustos del usuario.
        Debes recomendar maximo 3 peliculas.
        No incluyas peliculas que estén por fuera de la plataforma PlatziPlay
            """)
    public String generateMoviesSuggestion(@UserMessage String message);
}
