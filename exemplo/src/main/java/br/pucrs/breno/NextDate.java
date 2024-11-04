package br.pucrs.breno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class NextDate {
    
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final LocalDate DATA_MINIMA = LocalDate.of(1600, 1, 1);
    private static final LocalDate DATA_MAXIMA = LocalDate.of(9998, 12, 31);

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a data no formato: dd/mm/aaaa");
        String data = sc.nextLine();
        String result = calculaProximaData(data);
        System.out.println(result);


        sc.close();
    }

    public static String calculaProximaData(String data) {

        if(data.length() != 10) {
            return "ERRO: tamanho invalido.";
        }

        if(data.charAt(2) != '/' || data.charAt(5) != '/') {
            return "ERRO: nao utilizou barra.";
        }

        if(!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return "ERRO: nao utilizou digito.";
        }

        LocalDate dataInformada;
        try {
            dataInformada = LocalDate.parse(data, FORMATO_DATA);
        } catch (DateTimeParseException e) {
            return "ERRO: data invalida.";
        }

        if (dataInformada.isBefore(DATA_MINIMA) || dataInformada.isAfter(DATA_MAXIMA)) {
            return "ERRO: data invalida.";
        }

        LocalDate proximaData = dataInformada.plusDays(1);
        return "Data seguinte: " + proximaData.format(FORMATO_DATA);

    }
}

