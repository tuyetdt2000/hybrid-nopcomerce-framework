package javaOOP;

public class Dog extends Animals{
    // Trong cùng package thì không cần import class
    public static void main(String[] args) {
        Dog dog = new Dog();

        System.out.println(dog.getAnimalName());
        System.out.println(dog.animalAge);
        dog.setAnimalName("Dog set  Animal Name");
        System.out.println("================================================");
        System.out.println(dog.getAnimalName());
    }
}
