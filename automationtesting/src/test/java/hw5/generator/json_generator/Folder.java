package hw5.generator.json_generator;

import java.io.Serializable;

public class Folder implements Serializable {
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
