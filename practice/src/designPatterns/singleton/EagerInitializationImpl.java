package designPatterns.singleton;
class EagerInitialization{
    private static final EagerInitialization instance=new EagerInitialization();
    private EagerInitialization(){

    }
    public static EagerInitialization getInstance(){
        return instance;
    }
}
public class EagerInitializationImpl {
    public static void main(String[] args) {
        EagerInitialization e=EagerInitialization.getInstance();
        EagerInitialization e1=EagerInitialization.getInstance();
        System.out.println(e==e1);

    }
}
