package coreJava.general;

public class ConfigTemplateC {
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
        return "ConfigTemplateC{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
