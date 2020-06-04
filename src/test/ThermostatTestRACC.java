package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.*;

public class ThermostatTestRACC {
	private Thermostat thermo;
	private ProgrammedSettings settings;

	// if (((curTemp < dTemp - thresholdDiff) || (Override && curTemp < overTemp -
	// thresholdDiff)) && (timeSinceLastRun > minLag))
	// Predicate: (a || (b && c)) && d
	
	public void set_Info_t(int curTemp, int thresholdDiff, boolean override,int overtemp, int timeSinceLastRun, int minLag  ) {
		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff
		thermo.setCurrentTemp(curTemp);
		thermo.setThresholdDiff(thresholdDiff);
		
		// Clause b: Override 
		thermo.setOverride(override);
		
		// Clause c: curTemp < overTemp - thresholdDiff
		thermo.setOverTemp(overtemp);
		
		// Clause d: timeSinceLastRun.greaterThan (minLag)
		thermo.setMinLag(minLag);
		thermo.setTimeSinceLastRun(timeSinceLastRun);
		
		assertTrue(thermo.turnHeaterOn(settings));
	}

	public void set_Info_f(int curTemp, int thresholdDiff, boolean override,int overtemp, int timeSinceLastRun, int minLag  ) {
		// Instantiate needed objects
		thermo = new Thermostat();
		settings = new ProgrammedSettings();
		// Setting internal variable dTemp
		settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
		thermo.setPeriod(Period.MORNING);
		thermo.setDay(DayType.WEEKDAY);
		
		// Clause a: curTemp < dTemp - thresholdDiff
		thermo.setCurrentTemp(curTemp);
		thermo.setThresholdDiff(thresholdDiff);
		
		// Clause b: Override 
		thermo.setOverride(override);
		
		// Clause c: curTemp < overTemp - thresholdDiff
		thermo.setOverTemp(overtemp);
		
		// Clause d: timeSinceLastRun.greaterThan (minLag)
		thermo.setMinLag(minLag);
		thermo.setTimeSinceLastRun(timeSinceLastRun);
		
		assertFalse(thermo.turnHeaterOn(settings));
	}
	 	
		//1
		@Test
	    public void test1_1() {set_Info_t(65, 1, false, 65, 10, 8);} //1, 0, 0, 1, 1
		
		@Test
		public void test1_2() {set_Info_t(65, 5, true, 80, 10, 8);} //0, 1, 1, 1, 1
		
		@Test
		public void test1_3() {set_Info_f(65, 5, false, 65, 10, 8);} //0, 0, 0, 1, 0
		
		@Test
		public void test1_4() {set_Info_f(65, 5, false, 80, 10, 8);} //0, 0, 1, 1, 0
		
		@Test
		public void test1_5() {set_Info_f(65, 5, true, 65, 10, 8);} //0, 1, 0, 1, 0
		
		@Test
		public void test1_6() {set_Info_f(65, 5, true, 80, 8, 10);} //0, 1, 1, 0, 0 
		
		
		//2
		@Test
		public void test2_1() {set_Info_t(65, 1, false, 65, 10, 8);} //1, 0, 0, 1, 1
		
		@Test
		public void test2_2() {set_Info_t(65, 5, true, 80, 10, 8);}//0, 1, 1, 1, 1
		
		@Test
		public void test2_3() {set_Info_t(65, 1, false, 80, 10, 8);}//1, 0, 1, 1, 1
		
		@Test
		public void test2_4() {set_Info_f(65, 5, false, 65, 10, 8);}//0, 0, 0, 1, 0
		
		@Test
		public void test2_5() {set_Info_f(65, 5, false, 80, 10, 8);}//0, 0, 1, 1, 0
		
		@Test
		public void test2_6() {set_Info_f(65, 5, true, 65, 10, 8);}//0, 1, 0, 1, 0
		
		@Test
		public void test2_7() {set_Info_f(65, 1, false, 80, 8, 10);}//1, 0, 1, 0, 0 
		
		
		//3
		@Test
		public void test3_1() {set_Info_t(65, 1, false, 80, 10, 8);}//1, 0, 1, 1, 1
		
		@Test
		public void test3_2() {set_Info_t(65, 5, true, 80, 10, 8);}//0, 1, 1, 1, 1
		
		@Test
		public void test3_3() {set_Info_t(65, 1, false, 65, 10, 8);}//1, 0, 0, 1, 1
		
		@Test
		public void test3_4() {set_Info_f(65, 5, false, 80, 10, 8);}//0, 0, 1, 1, 0
		
		@Test
		public void test3_5() {set_Info_f(65, 5, true, 65, 10, 8);}//0, 1, 0, 1, 0
		
		@Test
		public void test3_6() {set_Info_f(65, 1, false, 65, 8, 10);}//1, 0, 0, 0, 0
		
		
		//4
		@Test
		public void test4_1(){set_Info_t(65, 1, false, 65, 10, 8);}//1, 0, 0, 1, 1
		
		@Test
		public void test4_2(){set_Info_t(65, 5, true, 80, 10, 8);}//0, 1, 1, 1, 1
		
		@Test
		public void test4_3(){set_Info_f(65, 5, false, 65, 10, 8);}//0, 0, 0, 1, 0
		
		@Test
		public void test4_4(){set_Info_f(65, 5, false, 80, 10, 8);}//0, 0, 1, 1, 0
		
		@Test
		public void test4_5(){set_Info_f(65, 5, true, 65, 10, 8);}//0, 1, 0, 1, 0
		
		@Test
		public void test4_6(){set_Info_f(65, 5, true, 80, 8, 10);}//0, 1, 1, 0, 0
		
		
		//5
		@Test
		public void test5_1(){set_Info_t(65, 1, false, 65, 10, 8);}//1, 0, 0, 1, 1
		
		@Test
		public void test5_2(){set_Info_t(65, 5, true, 80, 10, 8);}//0, 1, 1, 1, 1
		
		@Test
		public void test5_3(){set_Info_f(65, 5, false, 65, 10, 8);}//0, 0, 0, 1, 0
		
		@Test
		public void test5_4(){set_Info_f(65, 5, false, 80, 10, 8);}//0, 0, 1, 1, 0
		
		@Test
		public void test5_5(){set_Info_f(65, 5, true, 65, 10, 8);}//0, 1, 0, 1, 0
		
		@Test
		public void test5_6(){set_Info_f(65, 5, true, 80, 8, 10);}//0, 1, 1, 0, 0
}
