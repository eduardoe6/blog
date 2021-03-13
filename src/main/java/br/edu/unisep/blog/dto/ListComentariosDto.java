package br.edu.unisep.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ListComentariosDto {

    private String conteudo;
    private LocalDateTime data;
    private String nome;
}
