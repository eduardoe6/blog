package br.edu.unisep.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListUsuarioDto {

    private String nome;
    private String email;

}
