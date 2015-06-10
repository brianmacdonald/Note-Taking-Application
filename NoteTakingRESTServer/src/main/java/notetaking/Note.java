package notetaking;

import org.springframework.data.annotation.Id;

public class Note {

    @Id
    private String id;
    private String body;

    public Note(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
