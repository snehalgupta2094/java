package coreJava.general;

public class TestTemplates {

    public static void main(String[] args) {
        ConfigTemplate c = new ConfigTemplate();
        c.setId(1);
        c.setName("snehal");

        ConfigTemplateB cb = new ConfigTemplateB();
        cb.setName(c.getName());
        cb.setId(c.getId());

        System.out.println(cb);
        System.out.println(c);
    }
}
