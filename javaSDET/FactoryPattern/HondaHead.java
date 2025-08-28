package FactoryPattern;

public class HondaHead extends CarFactory {
    @Override
    public void viewCar() {
// Implement
        System.out.println("view HondaHead");
    }

    @Override
    public void bookCar() {
        System.out.println("book HondaHead");

    }

    @Override
    public void driveCar() {
        System.out.println("drive HondaHead");

    }

    public void turboCar() {
        System.out.println("turbo HondaHead");
    }
}
