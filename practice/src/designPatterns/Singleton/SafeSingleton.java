package designPatterns.Singleton;

import java.io.Serializable;

public enum SafeSingleton implements Serializable {
    INSTANCE;

    // Add your methods and properties here (optional)
    public void doSomething() {
        // Singleton logic
    }

    // Override readResolve method to handle deserialization properly
    protected Object readResolve() {
        return INSTANCE;
    }
}