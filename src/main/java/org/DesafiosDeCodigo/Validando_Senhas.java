package org.DesafiosDeCodigo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validando_Senhas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a senha para verificar a força:");
        String senha = scanner.nextLine();
        scanner.close();

        String resultado = verificarForcaSenha(senha);
        System.out.println(resultado);
    }
    public static String verificarForcaSenha(String senha){
        boolean temMaiuscula = Pattern.compile("[A-Z]").matcher(senha).find();
        boolean temNumero = Pattern.compile("[0-9]").matcher(senha).find();
        boolean temMinuscula = Pattern.compile("[a-z]").matcher(senha).find();
        boolean temCaracterEspecial = Pattern.compile("\\W").matcher(senha).find();
        boolean temSequencia = senha.matches(".*(?i)123456.*|.*(?i)abcdef.*");
        boolean temPalavraComum = senha.equalsIgnoreCase("password") || senha.equalsIgnoreCase("123456") || senha.equalsIgnoreCase("qwerty");


        if(senha.length() < 8){
           return "a sua senha é menor que o esperado, tente uma senha com o minimo de 8 caracteres";
        }else if(!temMinuscula || !temMaiuscula || !temNumero || !temCaracterEspecial){
            return "a sua senha nao atende aos criterion de segurança";
        }else if(!temSequencia || !temPalavraComum){
            return "senha segue os padroes corretos";
        }else{
            return "senha segue os padroes corretos";
        }
    }
}
