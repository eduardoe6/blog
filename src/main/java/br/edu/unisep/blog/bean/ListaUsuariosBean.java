package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.UsuarioDto;
import br.edu.unisep.blog.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListaUsuariosBean {

    @Getter
    @Setter
    private List<UsuarioDto> usuarios;

    private UsuarioRepository repo;

    @PostConstruct
    public void iniciar() {
        this.repo = new UsuarioRepository();
        this.usuarios = repo.listar();
    }
}
