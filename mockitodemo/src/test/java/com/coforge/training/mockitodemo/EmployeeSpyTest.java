package com.coforge.training.mockitodemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/*@Spy is used to create a spy instance. 
 * We can use it instead spy(Object) method.
 * Mockito provides option to create spy on real objects.
 * When spy is called, then actual method of real object is called.
 */
public class EmployeeSpyTest {
	
	private Employee spyEmp;
	private Employee emp;
	
	private static final String FIRST_NAME = "Aashi";
	private static final String LAST_NAME = "Gupta";
	private static final int AGE = 22;
	
	@Before
	public void buildSpy() {
		emp = new Employee(FIRST_NAME, LAST_NAME, AGE);
		spyEmp = spy(emp); //created a spy object of Employee using static method spy()
	}
	
	@Test
	public void verifySpyEffectOnRealInstance() {
		spyEmp.setAge(20);
		assertFalse(emp.getAge() == spyEmp.getAge());
		
	}
	@Test
	@DisplayName("Hello")
	public void verifySpyEffectOnRealInstance1() {
		spyEmp.setFirstName("Aashi");
		assertTrue(emp.getFirstName() == spyEmp.getFirstName());
	}
	
	@Test
	public void fullname() {
		System.out.println(emp.getFullName());
		System.out.println(spyEmp.getFullName());
		assertTrue(emp.getFullName().equals(spyEmp.getFullName()));
		//assertEquals(emp.getFullName(),spyEmp.getFullName());
	}

	@Test
	@DisplayName("Hi")
	public void verifySpyEffectOnRealInstance2() {
		spyEmp.setLastName("Gupta");
		System.out.println(emp.getLastName());
		System.out.println(spyEmp.getLastName());
		assertTrue(emp.getLastName() == spyEmp.getLastName());
	}

}
