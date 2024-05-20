
package com.example;

        import jakarta.annotation.ManagedBean;
        import jakarta.enterprise.context.RequestScoped;
        import jakarta.inject.Named;
        import jakarta.persistence.EntityManager;
        import jakarta.persistence.EntityManagerFactory;
        import jakarta.persistence.Persistence;
        import jakarta.persistence.TypedQuery;
        import java.util.List;

@Named
@ManagedBean
@RequestScoped
public class commentarybean {
    private commentary commentary = new commentary();
    private List<commentary> commentaries;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public commentary getCommentary() {
        return commentary;
    }

    public void setCommentary(commentary commentary) {
        this.commentary = commentary;
    }

    public List<commentary> getCommentaries() {
        TypedQuery<commentary> query = em.createQuery("SELECT c FROM commentary c", commentary.class);
        commentaries = query.getResultList();
        return commentaries;
    }

    public void saveCommentary() {
        em.getTransaction().begin();
        em.persist(commentary);
        em.getTransaction().commit();
        commentary = new commentary(); // Reset the form
    }
}
