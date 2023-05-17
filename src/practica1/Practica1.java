/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double res = 0;
        String operacion;
        boolean comprobar = false;

        do {

            double n1 = introduirDouble("primer");

            do {

                menuPrincipal();
                operacion = sc.nextLine();
                comprobar = comprobarOperacio(operacion);

            } while (comprobar != true);

            double n2 = introduirDouble("segon");

            do {
                comprobar = true;
                switch (operacion) {
                    case "+" ->
                        res = n2 + n2;
                    case "-" ->
                        res = n1 - n2;
                    case "x", "X" ->
                        res = n1 * n2;
                    case "/" -> {

                        if (n2 == 0) {

                            n2 = introduirDoubleDiferenteA0();

                        }

                        res = n1 / n2;
                    }
                    case "*" ->
                        res = Math.pow(n1, n1);
                    case "%" -> {
                        if (n2 == 0) {

                            n2 = introduirDoubleDiferenteA0();

                        }
                        res = n1 % n2;
                    }
                }
            } while (comprobar != true);

            System.out.println("El resultat de " + n1 + " " + operacion + " " + n2 + "  és " + res);
            System.out.print("Vols continuar operant? [s/n] \n>");
            
            operacion = retornarValorValidSortida();

            
        } while (operacion.equalsIgnoreCase("s") );
    }

    public static void menuPrincipal() {

        System.out.print("""
                                   Indica la operacio que vols utilitzar:
                                   Suma\t[+]
                                   Resta\t[-]
                                   Multiplicaci\u00f3\t[xX]
                                   Divisio\t[/][%]
                                   Exponent\t[*]
                                   Modul\t[%]
                                   >""");

    }

    public static boolean comprobarOperacio(String operacion) {

        return operacion.matches("[xX+-/*%]");

    }

    public static double introduirDouble(String valor) {

        System.out.print("Introdueix el " + valor + " numero \n>");

        do {

            if (sc.hasNextDouble()) {

                return sc.nextDouble();

            } else {
                System.out.println("Error, Introdueix un valor possible");
            }

            sc.nextLine();

        } while (true);

    }

    public static double introduirDoubleDiferenteA0() {

        System.out.println("Error al denominador hi ha un 0");

        do {

            if (sc.hasNextDouble()) {

                double num = sc.nextDouble();
                if (num == 0) {

                    System.out.println("Error, Introdueix un valor diferent a 0");
                } else {

                    return num;
                }

            } else {
                System.out.println("Error, Introdueix un valor possible");
            }

            sc.nextLine();

        } while (true);

    }

    public static boolean comprobarValorValidSortida(String valor) {

        return valor.matches("[sSnN]");

    }

    public static String retornarValorValidSortida() {
        
        sc.next();

        String valor = sc.nextLine();

        do {

            if (comprobarValorValidSortida(valor)) {

                return valor;
            
            } else {
                
                System.err.print("\n Error, posa un valor vàlid \n>");
                valor = sc.nextLine();
            }
            
            

        } while (true);

    }

}
