package designPatterns.singleton;

class LazyInitialization{
private static LazyInitialization instance=null;
private LazyInitialization(){

}
public static LazyInitialization getInstance(){
    if(instance==null){
        instance=new LazyInitialization();
    }
    return instance;
}
}
public class LazyInitializationImpl {

    public static void main(String[] args) {
        LazyInitialization l=LazyInitialization.getInstance();
        LazyInitialization l1=LazyInitialization.getInstance();
        System.out.println(l1==l);

    }
}
