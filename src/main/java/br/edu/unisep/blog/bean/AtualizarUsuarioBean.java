package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.AttUsuarioDto;
import br.edu.unisep.blog.repository.UsuarioRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AtualizarUsuarioBean {

    @Getter
    @Setter
    private AttUsuarioDto attUsuarioDto = new AttUsuarioDto();

    private UsuarioRepository repo = new UsuarioRepository();

    public String atualizar() {
        try {
            repo.atualizar(attUsuarioDto);
            return "/app/perfil?faces-redirect=true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "Não foi possível atualizar os dados!";
        }
    }
}
