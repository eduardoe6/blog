package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.dao.ComentarioDao;
import br.edu.unisep.blog.dto.ListComentariosDto;
import br.edu.unisep.blog.dto.NovoComentarioDto;
import br.edu.unisep.blog.entity.Comentario;
import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.exception.DaoException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComentarioRepository {

    private ComentarioDao dao = new ComentarioDao();

    public void salvar(NovoComentarioDto novoComentario) throws DaoException {

        var comentario = new Comentario();

        comentario.setConteudo(novoComentario.getConteudo());
        comentario.setData(LocalDateTime.now());

        var usuario = new Usuario();

        comentario.setUsuario(usuario);
    }

    public List<ListComentariosDto> listar(Integer idPost) {

        var comentarios = dao.findByPost(idPost);

        var retorno = new ArrayList<ListComentariosDto>();

        comentarios.forEach(c -> {

            retorno.add(new ListComentariosDto(
                    c.getConteudo(),
                    c.getData(),
                    c.getUsuario().getNome()));

        });

        return retorno;
    }
}
