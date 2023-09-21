package org.DesafiosDeCodigo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Monitoramento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeLogs = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner


        Map<String, Long> eventosPorServico = new HashMap<>();


        for (int i = 0; i < quantidadeLogs; i++) {
            String[] parts = scanner.nextLine().split(",");
            String servico = parts[1];
            int count = 1;
            //TODO: Utilize o mapa para registrar/incrementar o serviço em questão.


            if (eventosPorServico.containsKey(servico)) {
                count = (int) (eventosPorServico.get(servico) + 1);
            }
            eventosPorServico.put(servico, (long) count);
        }


        //TODO: Identifique no mapa os serviços com maior e menor quantidade de logs.
        //      Dica: Utilize Java Streams para tornar essa tarefa mais simples.
        String servicoMaiorLog = null;
        String servicoMenorLog = null;
        Long maiorLog = 0L;
        Long menorLog = 0L;




        for( Long l  : eventosPorServico.values()){
            if(maiorLog > l ){
                maiorLog = l;
            }
            if(menorLog < l){
                menorLog = l;
            }
        }


        for(Map.Entry<String, Long> entry : eventosPorServico.entrySet()){
            if(entry.getValue() > maiorLog){
                maiorLog = entry.getValue();
                servicoMaiorLog = entry.getKey();
            }
            if(entry.getValue() < menorLog){
                menorLog = entry.getValue();
                servicoMenorLog = entry.getKey();
            }
            if(menorLog == maiorLog){
                servicoMenorLog = entry.getKey();
                servicoMaiorLog = entry.getKey();
            }
        }


        //TODO: Imprima a saída no padrão definido no enunciado deste desafio.
        System.out.println("Eventos por servico:");
        for(Map.Entry<String, Long> entry : eventosPorServico.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().toString());
        }
        System.out.println("Maior:" + servicoMaiorLog);
        System.out.println("Menor:" + servicoMenorLog);


    }
    }

