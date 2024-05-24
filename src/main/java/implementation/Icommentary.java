package implementation;

import java.util.List;
import com.example.commentarys;

import java.util.List;
public interface Icommentary   {
    public void saveComment(commentarys com);
    public commentarys getcomentario();
    List<commentarys> getcomentarios();

    commentarys getComentario(Long id);

    List<commentarys> getComentarios();
}