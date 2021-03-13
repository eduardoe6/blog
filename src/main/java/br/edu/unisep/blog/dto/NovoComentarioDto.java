package br.edu.unisep.blog.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NovoComentarioDto {

    private String conteudo;
    private LocalDateTime data;
    private String nome;

    private String idPost;
}
