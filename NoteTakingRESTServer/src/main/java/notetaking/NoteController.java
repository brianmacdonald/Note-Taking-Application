package notetaking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class NoteController {

    @Autowired
    private NoteRepository repository;

    @RequestMapping(value="/api/notes/delete/all", method= RequestMethod.DELETE)
    public String cleanUp() {
        getRepository().deleteAll();
        return "Records deleted.";
    }

    @RequestMapping(value="/api/notes", method= RequestMethod.POST)
    public @ResponseBody Note createNote(@RequestBody Map<String, String> content) {
        Note createdNote = new Note(content.get("body"));
        return getRepository().save(createdNote);
    }

    @RequestMapping(value="/api/notes/{id}", method= RequestMethod.GET)
    public Note getExistingNote(@PathVariable("id") String id) {
        return getRepository().findById(id);
    }

    @RequestMapping(value="/api/notes", method= RequestMethod.GET)
    public List<Note> getNotesForQuery(@RequestParam(value="query", required=false) String query) {
        if (null != query) {
            return getRepository().findByQuery(query);
        } else {
            return getRepository().findAll();
        }
    }

    public NoteRepository getRepository() {
        return repository;
    }

    public void setRepository(NoteRepository repository) {
        this.repository = repository;
    }
}
