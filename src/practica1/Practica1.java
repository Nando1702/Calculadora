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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;

        do {

            String numero1;
            do {
                System.out.print("Introdueix el primer numero \n>");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);

            do {
                System.out.print("""
                                   Indica la operacio que vols utilitzar:
                                   Suma\t[+]
                                   Resta\t[-]
                                   Multiplicaci\u00f3\t[x][*]
                                   Divisio\t[/][%]
                                   >""");
                
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
            } while (comprobar != true);

            String numero2;
            do {
                System.out.print("Introdueix el segon numero \n>");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);

            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = n2 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        while (n2 == 0) {
                            do {
                                System.err.print("Error. Al denominador hi ha un zero!\n");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n1);
                        break;
                    case "%":
                        while (n2 == 0) {
                            do {
                                System.err.print("Error. Al denominador hi ha un zero!\n"
                                        );
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                }
            } while (comprobar != true);

            System.out.println("El resultat de " + numero1 + " " + operacion + " " + numero2 +  "  és " + res);
            System.out.print("Vols continuar operant? [s/n] \n>");

            do {
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\n Error, posa un valor vàlid. \n");
                        comprobar = false;
                }
            } while (comprobar != true);
        } while (operacion.equals("s") || operacion.equals("S"));
    }
}