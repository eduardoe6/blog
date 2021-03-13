package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.NovoUsuarioDto;
import br.edu.unisep.blog.repository.UsuarioRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NovoUsuarioBean {

    @Getter
    @Setter
    private NovoUsuarioDto novoUsuario = new NovoUsuarioDto();

    private UsuarioRepository repo = new UsuarioRepository();

    public String salvar() {
        try {
            repo.cadastrar(novoUsuario);
            return "/index?faces-redirect=true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "Não foi possível realizar o cadastro";
        }
    }
}
