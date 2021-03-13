package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.NovoComentarioDto;
import br.edu.unisep.blog.repository.ComentarioRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NovoComentarioBean {

    @Getter
    @Setter
    private ComentarioRepository repo = new ComentarioRepository();

    private NovoComentarioDto novoComentario = new NovoComentarioDto();

    public String salvar() {
        try {
            repo.salvar(novoComentario);
            return "/app/post?faces-redirect=true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "app/post";
        }
    }
}
