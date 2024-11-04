package br.pucrs.breno;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple NextDate.
 */
class NextDateTest {
    @Test
    public void testCalculaProximaData_DataValida() {
        String resultado = NextDate.calculaProximaData("10/08/2004");
        assertEquals("Data seguinte: 11/08/2004", resultado);
    }

    @Test
    public void testCalculaProximaData_TamanhoInvalido() {
        String resultado = NextDate.calculaProximaData("10/08/04");
        assertEquals("ERRO: tamanho invalido.", resultado);
    }

    @Test
    public void testCalculaProximaData_NaoUtilizouDigito() {
        String resultado = NextDate.calculaProximaData("10/AB/2004");
        assertEquals("ERRO: nao utilizou digito.", resultado);
    }

    @Test
    public void testCalculaProximaData_NaoUtilizouBarra() {
        String resultado = NextDate.calculaProximaData("10-08-2004");
        assertEquals("ERRO: nao utilizou barra.", resultado);
    }

    @Test
    public void testCalculaProximaData_DataForaDoIntervaloAcima() {
        String resultado = NextDate.calculaProximaData("31/12/9999");
        assertEquals("ERRO: data invalida.", resultado);
    }

    @Test
    public void testCalculaProximaData_DataForaDoIntervalo() {
        String resultado = NextDate.calculaProximaData("10/08/1000");
        assertEquals("ERRO: data invalida.", resultado);
    }

    @Test
    public void testCalculaProximaData_DataInvalida() {
        String resultado = NextDate.calculaProximaData("32/01/2004");
        assertEquals("ERRO: data invalida.", resultado);
    }

    @Test
    public void testCalculaProximaData_DataVazia() {
        String resultado = NextDate.calculaProximaData("");
        assertEquals("ERRO: tamanho invalido.", resultado);
    }

    @Test
    public void testCalculaProximaData_DataComCaracteresInvalidos() {
        String resultado = NextDate.calculaProximaData("10/08/20AB");
        assertEquals("ERRO: nao utilizou digito.", resultado);
    }

    @Test
    public void testCalculaProximaData_DataComEspacos() {
        String resultado = NextDate.calculaProximaData("10 / 08 / 2004");
        assertEquals("ERRO: tamanho invalido.", resultado);
    }

    @Test
    public void testMain() {
        
        String input = "10/08/2004\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        NextDate.main(new String[]{});

        String expectedOutput = "Informe a data no formato: dd/mm/aaaa\nData seguinte: 11/08/2004\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
