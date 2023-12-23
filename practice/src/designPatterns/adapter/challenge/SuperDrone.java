package designPatterns.adapter.challenge;

public class SuperDrone implements Drone{

    @Override
    public void beep() {
        System.out.println("Beep beep beep!");
    }

    @Override
    public void spin_rotors() {
        System.out.println("Rotors are spinning!");
    }

    @Override
    public void takeOff() {
        System.out.println("Take Off!");
    }
}
