package FactoryPattern;

public class EndUser {

    public  static CarFactory carFactory;
    public static void main(String[] args) {

        carFactory= getCarFactory("HondaHead");
        carFactory.viewCar();
        carFactory.bookCar();
        carFactory.driveCar();
        // Ham rieng cho  1 doi tương
        ((HondaHead) carFactory).turboCar();


    }

    public static CarFactory getCarFactory(String carType) {
        return switch (carType) {
            case "HondaHead" -> new HondaHead();
            case "FordHead" -> new FordHead();
            case "HyundaiHead" -> new HyundaiHead();
            default -> throw new IllegalStateException("Unexpected value: " + carType);
        };

    }
}
