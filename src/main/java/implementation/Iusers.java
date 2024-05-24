package implementation;
import com.example.users;
import jakarta.transaction.Transactional;

public interface Iusers{
   @Transactional
   void save(users user);

}