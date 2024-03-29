package designPatterns.adapter.challenge;

public class TurkeyAdapter implements Duck {
    Turkey turkey;
    TurkeyAdapter(Turkey turkey){
        this.turkey=turkey;
    }
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for(int i=0;i<5;i++){
            System.out.println("Fly duck!");
        }
    }
}
