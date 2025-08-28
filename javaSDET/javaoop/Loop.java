package javaoop;

public class Loop {

    public static void main(String[] args) {
        System.out.println("==============for===============");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("==============white===============");
        int i=1;
        while (i< 11 ) {
            System.out.println(i);
            i++;
        }

        System.out.println("============== do white===============");
        int x = 0;
        do {
            System.out.println(x);
            x++;
        }while (x< 11 );

        System.out.println("============== for each===============");
        Integer[] integers = {1,2,3,4,5,6,7,8,9,10};

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
