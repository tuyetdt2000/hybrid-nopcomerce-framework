package javaoop.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Duck extends Animals implements  Flyable, Swimmable, Walkable{
    public Duck() {

    }

    @Override
    public void makeSound() {
        System.out.println(animalName + " says: Quack!");


    }

    @Override
    public void fly() {
        System.out.println(animalName + " is flying.");

    }

    @Override
    public void swim() {
        System.out.println(animalName + " is swimming.");

    }

    @Override
    public void walk() {
        System.out.println(animalName + " is walking");

    }

    public  void infoDuck(Duck duck){
        duck.sleep();
        duck.fly();
        duck.swim();
        duck.walk();

    }

    public static void main(String[] args) {
        Duck duck1 = new Duck();
        Duck duck2 = new Duck();
        duck1.setAnimalName("Duck1");
        duck2.setAnimalName("Duck2");
        List<Duck> listDuck = new ArrayList<>();
        listDuck.add(duck1);
        listDuck.add(duck2);
         for(Duck d : listDuck){
             d.infoDuck(d);
         }



    }
}
