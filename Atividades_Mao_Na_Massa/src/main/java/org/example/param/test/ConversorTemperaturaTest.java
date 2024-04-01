package org.example.param.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.param.temperature.Celsius;
import org.example.param.temperature.ConversorTemperatura;
import org.example.param.temperature.Fahrenheit;
import org.example.param.temperature.TempException;
import org.example.param.temperature.Temperatura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConversorTemperaturaTest {

	@Test
	void converteCelsiusSucesso() throws TempException {
		ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
		Temperatura tempCelsius = new Celsius();

		tempCelsius.setValue(100);
		Temperatura tempFahrenheit = conversorTemperatura.converte(tempCelsius);
		Assertions.assertInstanceOf(Fahrenheit.class, tempFahrenheit);
		assertEquals(tempFahrenheit.getValue(), 212);
	}

	@Test
	void converteFahrenheitSucesso() throws TempException {
		ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
		Temperatura tempFahrenheit = new Fahrenheit();

		tempFahrenheit.setValue(32);
		Temperatura tempCelsius = conversorTemperatura.converte(tempFahrenheit);
		Assertions.assertInstanceOf(Celsius.class, tempCelsius);
		assertEquals(tempCelsius.getValue(), 0);
	}
}
