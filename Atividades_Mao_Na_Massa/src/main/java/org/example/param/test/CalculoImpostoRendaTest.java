package org.example.param.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.example.param.CalculoImpostoRenda;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculoImpostoRendaTest {

	@ParameterizedTest
	@MethodSource("valoresCalculaImposto")
	void calculaImpostoShouldReturnCorrectPercent(double value, double expected) {
		assertEquals(CalculoImpostoRenda.calculaImposto(value), expected, 0.001);
	}

	private static Stream<Arguments> valoresCalculaImposto() {
		return Stream.of(
				Arguments.of(1202, 1202*0.1),
				Arguments.of(5002, 5002*0.15),
				Arguments.of(100, 0),
				Arguments.of(12000, 12000*0.2)
		);
	}


	@Test
	void calculaImpostoShouldThrowValorInvalidoException() {
		Exception ex = Assert.assertThrows(RuntimeException.class, () -> CalculoImpostoRenda.calculaImposto(-10));

		String expectedMessage = "Valor inválido!";
		assertEquals(expectedMessage, ex.getMessage());
	}
}
