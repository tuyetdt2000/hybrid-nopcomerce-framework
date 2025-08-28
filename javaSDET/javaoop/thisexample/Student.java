package javaoop.thisexample;

public class Student extends Person {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public void print() {
        System.out.println("id " + id + " - " + " name " + name);
    }

    public void printChild1() {
        this.print(); // Goi method cua class hien tai
    }

    public void printChild2() {
        super.print(); // Goi method cua class cha
    }

    public static void main(String[] args) {

        Student student = new Student(1, "Tuyetdt");
        student.print();
        student.printChild1();
        student.printChild2();
    }

}
