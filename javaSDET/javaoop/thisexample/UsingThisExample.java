package javaoop.thisexample;

public class UsingThisExample {

    private int id;
    private final String website;
    private final String subject;

    //
//    public UsingThisExample(String website, String subject) {
//        website = website; Cung tham so bien local che mat bien instance
//        subject = subject;
//    }
    public UsingThisExample(String website, String subject) {
        this.website = website;
        this.subject = subject;
    }


    public void print() {
        System.out.println("ID: " + id);
        this.printWebsite();
        this.printSubject();
    }

    public void printWebsite() {
        System.out.println("Website: " + website);
    }

    public void printSubject() {
        System.out.println("Subject: " + subject);
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        UsingThisExample usingThisExample = new UsingThisExample("www.google.com", "Google");
        usingThisExample.print();
    }
}
