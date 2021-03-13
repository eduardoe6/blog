package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.ListComentariosDto;
import br.edu.unisep.blog.dto.PostDto;
import br.edu.unisep.blog.repository.ComentarioRepository;
import br.edu.unisep.blog.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class VisualizarPostBean {

    @Getter
    @Setter
    private Integer idPost;

    @Getter
    @Setter
    private ListComentariosDto comentariosDto;

    @Getter
    @Setter
    private PostDto post;

    private ComentarioRepository comentarioRepo;

    private PostRepository repo;

    @Getter
    @Setter
    private List<ListComentariosDto> comentarios;


    public void iniciar() {
        this.repo = new PostRepository();
        this.post = repo.consultar(idPost);

        this.comentarioRepo = new ComentarioRepository();
        this.comentarios = comentarioRepo.listar(idPost);
    }
}
