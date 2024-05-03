package coreJava.general;

import java.io.Serializable;

public class ConfigTemplate implements Serializable {
    private static final long serialVersionUID = 3518943344231002376L;
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ConfigTemplate{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
