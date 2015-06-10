package notetaking;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    @Query("{ 'body': {$regex:?0,$options:'i'}}")
    public List<Note> findByQuery(String query);

    public Note findById(String id);
}
