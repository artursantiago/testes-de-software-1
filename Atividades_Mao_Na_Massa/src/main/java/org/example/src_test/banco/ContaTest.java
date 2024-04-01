package org.example.src_test.banco;


import org.example.banco.Conta;
import org.example.banco.OperacaoIlegalException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ContaTest {

	@Test
	public void testDebitarSucesso() throws OperacaoIlegalException {
		Conta c = new Conta("123", 20);
		c.debitar(10);
		assertEquals(10,c.getSaldo(),0.0);
	}

	@Test
	public void testTransferirSucesso() throws OperacaoIlegalException {
		Conta c = new Conta("123", 20);
		Conta cDestino = new Conta("321", 20);
		c.transferir(cDestino, 10);
		assertEquals(10,c.getSaldo(),0.0);
		assertEquals(30,cDestino.getSaldo(),0.0);
	}

	@Test
	public void testTransferirErroSaldoInsuficiente() throws OperacaoIlegalException {
		Conta c = new Conta("123", 0);
		Conta cDestino = new Conta("321", 20);
		try {
			c.transferir(cDestino, 10);
			fail("Erro");
		} catch (OperacaoIlegalException ignored) {
		}
	}
}
