package fifthWeek;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private String name;
    private List<Message> messages = new ArrayList<Message>();

    void add(Message msg) {
        messages.add(msg);
    }

    String name() {
        return name;
    }
}