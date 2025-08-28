package nonFactoryPattern;

public class EndUser {
    public static void main(String[] args) {
        //Cung 1 cong viec thuc hien voi nhieu doi tuong khac nhau
        HondaHead hd = new HondaHead();
        hd.viewCar();
        hd.bookCar();
        hd.driveCar();
        FordHead fd = new FordHead();
        fd.viewCar();
        fd.bookCar();
        fd.driveCar();
        HondaHead hd2 = new HondaHead();
        hd2.viewCar();
        hd2.bookCar();
        hd2.driveCar();


    }
}
