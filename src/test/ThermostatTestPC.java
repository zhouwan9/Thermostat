package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.*;


public class ThermostatTestPC {
	private Thermostat thermo;
	private ProgrammedSettings settings;

	// if (((curTemp < dTemp - thresholdDiff) || (Override && curTemp < overTemp -
	// thresholdDiff)) && (timeSinceLastRun > minLag))
	// Predicate: (a || (b && c)) && d

	@Test
	public void testPCtrue_1() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: F
		// Predicate: lines 28-30
		// Expected Output: F

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : F
		thermo.setCurrentTemp(66);
		thermo.setThresholdDiff(5);
		// Clause b: Override : F
		thermo.setOverride(false);
		// Clause c: curTemp < overTemp - thresholdDiff : T
		thermo.setOverTemp(80);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : T
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(19);
		// Run the test
		assertFalse(thermo.turnHeaterOn(settings));
	}
	
	@Test
	public void testPCfalse_1() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: T
		// Predicate: lines 28-30
		// Expected Output: T

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : T
		thermo.setCurrentTemp(60);
		thermo.setThresholdDiff(5);
		// Clause b: Override : T
		thermo.setOverride(true);
		// Clause c: curTemp < overTemp - thresholdDiff : T
		thermo.setOverTemp(80);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : T
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(19);
		// Run the test
		assertTrue(thermo.turnHeaterOn(settings));
	}

	@Test
	public void testPCtrue_2() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: F
		// Predicate: lines 28-30
		// Expected Output: F

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : F
		thermo.setCurrentTemp(66);
		thermo.setThresholdDiff(5);
		// Clause b: Override : T
		thermo.setOverride(true);
		// Clause c: curTemp < overTemp - thresholdDiff : F
		thermo.setOverTemp(66);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : T
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(19);
		// Run the test
		assertFalse(thermo.turnHeaterOn(settings));
	}
	
	@Test
	public void testPCfalse_2() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: T
		// Predicate: lines 28-30
		// Expected Output: T

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : T
		thermo.setCurrentTemp(60);
		thermo.setThresholdDiff(5);
		// Clause b: Override : F
		thermo.setOverride(false);
		// Clause c: curTemp < overTemp - thresholdDiff : T
		thermo.setOverTemp(80);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : T
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(19);
		// Run the test
		assertTrue(thermo.turnHeaterOn(settings));
	}
	
	@Test
	public void testPCtrue_3() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: F
		// Predicate: lines 28-30
		// Expected Output: F

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : T
		thermo.setCurrentTemp(60);
		thermo.setThresholdDiff(5);
		// Clause b: Override : T
		thermo.setOverride(true);
		// Clause c: curTemp < overTemp - thresholdDiff : F
		thermo.setOverTemp(60);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : F
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(9);
		// Run the test
		assertFalse(thermo.turnHeaterOn(settings));
	}
	
	@Test
	public void testPCfalse_3() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: T
		// Predicate: lines 28-30
		// Expected Output: T

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : T
		thermo.setCurrentTemp(60);
		thermo.setThresholdDiff(5);
		// Clause b: Override : F
		thermo.setOverride(false);
		// Clause c: curTemp < overTemp - thresholdDiff : T
		thermo.setOverTemp(80);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : T
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(19);
		// Run the test
		assertTrue(thermo.turnHeaterOn(settings));
	}	

	@Test
	public void testPCtrue_4() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: F
		// Predicate: lines 28-30
		// Expected Output: F

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : T
		thermo.setCurrentTemp(60);
		thermo.setThresholdDiff(5);
		// Clause b: Override : F
		thermo.setOverride(false);
		// Clause c: curTemp < overTemp - thresholdDiff : T
		thermo.setOverTemp(80);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : F
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(9);
		// Run the test
		assertFalse(thermo.turnHeaterOn(settings));
	}
	
	@Test
	public void testPCfalse_4() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: T
		// Predicate: lines 28-30
		// Expected Output: T

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : T
		thermo.setCurrentTemp(60);
		thermo.setThresholdDiff(5);
		// Clause b: Override : T
		thermo.setOverride(true);
		// Clause c: curTemp < overTemp - thresholdDiff : F
		thermo.setOverTemp(60);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : T
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(19);
		// Run the test
		assertTrue(thermo.turnHeaterOn(settings));
	}	

	@Test
	public void testPCtrue_5() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: F
		// Predicate: lines 28-30
		// Expected Output: F

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : T
		thermo.setCurrentTemp(60);
		thermo.setThresholdDiff(5);
		// Clause b: Override : F
		thermo.setOverride(false);
		// Clause c: curTemp < overTemp - thresholdDiff : T
		thermo.setOverTemp(80);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : F
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(9);
		// Run the test
		assertFalse(thermo.turnHeaterOn(settings));
	}
	
	@Test
	public void testPCfalse_5() {
		// Partial test for method turnHeaterOn() in class Thermostat
		// Criterion: PC
		// Value: T
		// Predicate: lines 28-30
		// Expected Output: T

		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff : T
		thermo.setCurrentTemp(60);
		thermo.setThresholdDiff(5);
		// Clause b: Override : T
		thermo.setOverride(true);
		// Clause c: curTemp < overTemp - thresholdDiff : T
		thermo.setOverTemp(80);
		// Clause d: timeSinceLastRun.greaterThan (minLag) : T
		thermo.setMinLag(10);
		thermo.setTimeSinceLastRun(19);
		// Run the test
		assertTrue(thermo.turnHeaterOn(settings));
	}	
}