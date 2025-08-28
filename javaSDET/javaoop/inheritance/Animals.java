package javaoop.inheritance;

public abstract class Animals {
    protected String animalName;
    protected int animalAge ;


    protected String getAnimalName() {  //Getter
        return animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    protected void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }
    protected void sleep() {
        System.out.println(animalName + " is sleeping");

    }
    protected  void eat(){
        System.out.println(animalName + " is eating");
    }
    public abstract void makeSound();


}
