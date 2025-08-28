package javaoop.inheritance;

public abstract class Dog extends Animals {
    // Trong cùng package thì không cần import class
    public static void main(String[] args) {
        Dog dog = new Dog() {
            @Override
            public void makeSound() {

            }
        };
       dog.setAnimalName("Dog");
       System.out.println("Name:" + dog.getAnimalName());
       dog.sleep();
       dog.eat();
    }
}
