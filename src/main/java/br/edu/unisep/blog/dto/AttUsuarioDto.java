package br.edu.unisep.blog.dto;

import lombok.Data;

@Data
public class AttUsuarioDto {

    private String login;
    private String email;
    private String nome;
    private String senha;

}
