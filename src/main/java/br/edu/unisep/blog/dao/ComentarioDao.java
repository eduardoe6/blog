package br.edu.unisep.blog.dao;

import br.edu.unisep.blog.entity.Comentario;
import com.rcpadilha.hibernate.factory.HibernateSessionFactory;

import java.util.List;

public class ComentarioDao {

    public List<Comentario> findByPost(Integer idPost) {

        var session = HibernateSessionFactory.getSession();
        var q = session.createQuery("from Comentario where post.id = :POST", Comentario.class);

        q.setParameter("POST", idPost);

        var lista = q.list();

        session.close();

        return lista;
    }
}
