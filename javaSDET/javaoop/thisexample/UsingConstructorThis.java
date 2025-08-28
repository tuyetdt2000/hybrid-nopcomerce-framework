package javaoop.thisexample;

public class UsingConstructorThis {

    private int x;
    private String name;
    private String subject;

    public UsingConstructorThis() {
        this.x = 1;
        this.name = "This is a name 1";
    }

    public UsingConstructorThis(String name) {
        this();
        this.name = name;
    }

    public UsingConstructorThis(String name, String subject) {
        this(name);
        this.subject = subject;

    }

    public UsingConstructorThis(int x, String name, String subject) {
        this.x = x;
        this.name = name;
        this.subject = subject;
    }

    public void print() {
        System.out.println("id =" + x);
        printName();
        printSubject();

    }

    public void printName() {
        System.out.println("name =" + name);
    }

    public void printSubject() {
        System.out.println("subject =" + subject);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static void main(String[] args) {

        UsingConstructorThis obj = new UsingConstructorThis(3, "Tuyet co 2", "Subject");
        obj.print();

    }
}
