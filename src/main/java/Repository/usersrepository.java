package Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import com.example.users;
import implementation.Iusers;
@ApplicationScoped
public class usersrepository implements Iusers {

    @Inject
    EntityManager em;

    @Override
        @Transactional
        public void save(users user) {em.persist(user);}
    }
