package com.JavaPOOEjercicios;

import java.util.Scanner;

class BinaryArray {
    //Creacion del binary array con sus corespondientes getters y setters
    String boolstring;

    public String getBoolstring() {
         return boolstring;
    }

    public static void setBoolstring(String boolstr) {
        boolstr = boolstr;
    }

    public BinaryArray () {
        getBoolstring();
    }
}

public class act1 {
    //Simplemente es un metodo que tiene que devolver un bolean segun si introducimos una T de true o una F de fasle
    public static void main(String[] args) {

        System.out.println("Introduce array de 4 digitos (t o f): ");
        Scanner scanner = new Scanner(System.in);

        //Para que sean en mayusculas
        String sc = scanner.nextLine().toUpperCase();

        //seteamos el estring
        BinaryArray.setBoolstring(sc);

        boolean[] boolch = new boolean[4];

        char[] strTochar = sc.toCharArray();
        for (int i = 0; i<strTochar.length; i++) {
            if (strTochar[i] == 'T') {
                boolch[i] = true;
            } else {
                boolch[i] = false;
            }
        }
        for (int i = 0; i < boolch.length; i++) {
            System.out.println(boolch[i]);
        }
    }
}