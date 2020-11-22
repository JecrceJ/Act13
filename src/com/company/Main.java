package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;


interface AnonClass {
    void anonMethod();
}
class ref{
    String a= "Referenciado";
}
public class Main {

    public static void main(String[] args) {
        // write your code here}
        List<String> texto = new ArrayList<>();
        texto.add("Alex");
        texto.add("Jose");
        texto.add("Alberto");
        texto.add("Hernan");
        texto.add("Enrique");
        texto.add("Francisco");
        texto.add("Cristian");
        texto.add("Jorge");
        texto.add("Ivan");
        texto.add("Benito");

        texto.sort((o1, o2) -> o1.compareTo(o2));       //LAMBDA ALFABETICAMENTE
        System.out.println("****************LAMBDA***************");
        for (String text : texto) {
            System.out.println(text);
        }

        sort(texto, (arg0, arg1) -> {                   //LAMBDA LONGITUD
            int larg0 = arg0.length();
            int larg1 = arg1.length();
            return larg0 < larg1 ? -1 : larg0 > larg1 ? 1 : 0;
        });
        System.out.println("****************LAMBDA***************");
        for (String s : texto) {
            System.out.println(s);
        }

        AnonClass anon = new AnonClass() {              //CLASE ANONIMA ALFABETICAMENTE
            @Override
            public void anonMethod() {
                sort(texto);
                System.out.println("****************ANONIMA***************");
                for (String text : texto) {
                    System.out.println(text);
                }

            }
        };
        anon.anonMethod();

        AnonClass anon1 = new AnonClass() {              //CLASE ANONIMA LONGITUD
            @Override
            public void anonMethod() {
                sort(texto, new Comparator<String>() {
                    public int compare(String arg0, String arg1) {
                        int larg0 = arg0.length();
                        int larg1 = arg1.length();
                        return larg0 < larg1 ? -1 : larg0 > larg1 ? 1 : 0;
                    }
                });
                System.out.println("****************ANONIMA***************");
                for (String s : texto) {
                    System.out.println(s);
                }
            }
        };
        anon1.anonMethod();

        System.out.println("*********CLASE REFERENCIADA***********");
        AnonClass sout = ref::new;                  //Clase referenciada Alfabeticamente
        sort(texto);
        for (String text : texto) {
            System.out.println(text);
        }

        System.out.println("*********CLASE REFERENCIADA***********");
        AnonClass sout2 = ref::new;                  //Clase referenciada Longitud
        sort(texto, new Comparator<String>() {
            public int compare(String arg0, String arg1) {
                int larg0 = arg0.length();
                int larg1 = arg1.length();
                return larg0 < larg1 ? -1 : larg0 > larg1 ? 1 : 0;
            }
        });
        for (String s : texto) {
            System.out.println(s);
        }
    }
}
