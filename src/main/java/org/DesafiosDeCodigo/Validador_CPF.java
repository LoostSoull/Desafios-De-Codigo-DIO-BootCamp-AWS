package org.DesafiosDeCodigo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validador_CPF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CPF : ");
        String cpf = sc.nextLine();


        String resultado = verificarCpf(cpf);
        System.out.println(resultado);
    }

    public static String verificarCpf(String cpf) {

        boolean temSomenteNumeros = Pattern.compile("(^\\d+[0-9]{3}\\.\\d+[0-9]{3}\\.\\d[0-9]{3}\\-\\d{2}$)").matcher(cpf).find();

        if (cpf.length() < 11 && !temSomenteNumeros) {
            return "CPF invalido";
        } else {
            return "CPF validado e correto!";
        }
    }
}
