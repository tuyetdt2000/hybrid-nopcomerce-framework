package javaOOP;

public class Animals {
    private String animalName = "Shark";
    protected int animalAge = 5;
    public String publicAnimalName;

    protected String getAnimalName() {  //Getter
        return animalName;
    }
    protected void setAnimalName(String animalName) {
        this.animalName=animalName;
    }


}
