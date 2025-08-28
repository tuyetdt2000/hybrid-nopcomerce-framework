package javaoop;

import java.util.Scanner;

public class Branch {


    public static void main(String[] args) {

        int i ;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Branch Name: ");
        i = sc.nextInt();
        System.out.println("====== if 1====");
        if (i ==1){
            System.out.println("Enter Branch Name: " + i);
        }
        System.out.println("====== if 2====");

        if (i == 1){
            System.out.println("Enter Branch Name: " + i);
        }else {
            System.out.println("Enter Branch Name other  " + i);
        }
        System.out.println("====== if 3====");

        if (i == 1){
            System.out.println("Enter Branch Name: " + i);
        }else if (i == 2) {
            System.out.println("Enter Branch Name   " + i);
        }else {
            System.out.println("Enter Branch Name   " + i);
        }

        System.out.println("======switch case====");
        int day;
        System.out.println("Enter day Name: ");
        day = sc.nextInt();
        switch (day) {
            case 1 :
                System.out.println("Monday");
            case 2:
                System.out.println("Tuesday");
        }





    }
}
