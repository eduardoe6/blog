package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.NovoPostDto;
import br.edu.unisep.blog.repository.PostRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NovoPostBean {

    @Inject
    private UsuarioBean UsuarioBean;

    @Getter
    @Setter
    private NovoPostDto novoPost = new NovoPostDto();

    private PostRepository repo = new PostRepository();

    public String salvar() {
        try {
            novoPost.setIdUsuario(UsuarioBean.getUsuario().getLogin());
            repo.salvar(novoPost);
            return "/app/home?faces-redirect=true";
        } catch (DaoException e) {
            return "app/novoPost";
        }
    }

}
