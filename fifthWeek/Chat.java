package fifthWeek;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private String name;
    private List<String> messages = new ArrayList<>();

    void add(String msg) {
        messages.add(msg);
    }

    String name() {
        return name;
    }
}