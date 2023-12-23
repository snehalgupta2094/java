package designPatterns.adapter.challenge;

public class DroneAdapter implements Duck{
    Drone drone;
    DroneAdapter(Drone drone){
        this.drone=drone;
    }
    @Override
    public void quack() {
        drone.beep();
    }

    @Override
    public void fly() {
        drone.spin_rotors();
        drone.takeOff();
    }
}
