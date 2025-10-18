package org.example.util;

import java.util.Scanner;

public class TecladoUtil {
    public static String lerString(String mensagem) {
        return incializaTeclado(mensagem).nextLine();
    }

    public static Integer lerInt(String mensagem) {
        return incializaTeclado(mensagem).nextInt();
    }

    private static Scanner incializaTeclado(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

}
