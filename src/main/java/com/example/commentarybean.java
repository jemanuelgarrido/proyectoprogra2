package com.example;

import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Named
@RequestScoped
public class commentarybean {

    @PersistenceContext
    private EntityManager em;

    private commentary commentary = new commentary();

    public List<commentary> getCommentaries() {
        TypedQuery<commentary> query = em.createQuery("SELECT c FROM commentary c ORDER BY c.fecha DESC", commentary.class);
        return query.getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public com.example.commentary getCommentary() {
        return commentary;
    }

    public void setCommentary(com.example.commentary commentary) {
        this.commentary = commentary;
    }

    public void saveCommentary() {
        if (isCommentaryValid()) {
            em.persist(commentary);
            commentary = new commentary(); // Reset the commentary object after saving
        }
    }

    private boolean isCommentaryValid() {
        if (commentary.getNombre() == null || commentary.getNombre().isEmpty()) {
            return false;
        }
        if (commentary.getEmail() == null || commentary.getEmail().isEmpty()) {
            return false;
        }
        if (commentary.getComentario() == null || commentary.getComentario().isEmpty()) {
            return false;
        }
        return true;
    }
}


