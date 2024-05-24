package Repository;

import com.example.commentarys;
import implementation.Icommentary;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class commentaryrepository implements Icommentary {

    @Inject
    EntityManager em;

    @Override
    @Transactional
    public void saveComment(commentarys com) {
        em.persist(com);
        // Lógica adicional para guardar el comentario en un archivo txt
        // Ejemplo:
        // try (PrintWriter out = new PrintWriter(new FileWriter("comentarios.txt", true))) {
        //     out.println(com.getTexto());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    @Override
    public commentarys getcomentario() {
        return null;
    }

    @Override
    public List<commentarys> getcomentarios() {
        return null;
    }

    @Override
    public commentarys getComentario(Long id) {
        return em.find(commentarys.class, id);
    }

    @Override
    public List<commentarys> getComentarios() {
        return em.createQuery("SELECT c FROM commentarys c", commentarys.class).getResultList();
    }
}
