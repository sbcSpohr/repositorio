package br.pucrs.breno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple NextDate.
 */
class NextDateTest {
    /**
     * Rigorous Test.
     */
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
    public void testCalculaProximaData_DataForaDoIntervalo() {
        String resultado = NextDate.calculaProximaData("31/12/9999");
        assertEquals("ERRO: data invalida.", resultado);
    }

    @Test
    public void testCalculaProximaData_DataInvalida() {
        String resultado = NextDate.calculaProximaData("32/01/2004");
        assertEquals("ERRO: data invalida.", resultado);
    }
}

