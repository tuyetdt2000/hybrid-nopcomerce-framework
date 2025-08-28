package FactoryPattern;

public class FordHead extends CarFactory {
    @Override
    public void viewCar() {
// Implement
        System.out.println("view FordHead");
    }

    @Override
    public void bookCar() {
        System.out.println("book FordHead");

    }

    @Override
    public void driveCar() {
        System.out.println("drive FordHead");

    }

    public void turboCar() {
        System.out.println("turbo FordHead");
    }
}
