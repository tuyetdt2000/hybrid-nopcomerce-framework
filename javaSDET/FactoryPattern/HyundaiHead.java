package FactoryPattern;

public class HyundaiHead extends CarFactory {
    @Override
    public void viewCar() {
// Implement
        System.out.println("view HyundaiHead");
    }

    @Override
    public void bookCar() {
        System.out.println("book HyundaiHead");

    }

    @Override
    public void driveCar() {
        System.out.println("drive HyundaiHead");

    }

    public void turboDemoCar() {
        System.out.println("turbo HyundaiHead");
    }
}
