package com.raveture.eval;



import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.services.CostumerServices;

public class UserLoginTest {
	
	private static  CostumerServices cs;
	
	public ExpectedException expectedException = ExpectedException.none();

	
	@Test(expected = NullPointerException.class)
	public void testlogIn() {
		cs.logIn("jsajkdhk");
}
}
