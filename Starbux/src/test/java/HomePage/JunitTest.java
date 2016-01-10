package HomePage;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTest {

	@Test
		
	public void test3(){
	assertFalse("Fail because 1 is equal to 1",1==1);

}
	@Test 
	public void test4(){
		assertTrue("Fail because 1 is not equal to 0",1==0);
}
	@Test
	public void test5(){
		assertTrue("Fail because 1 is not equal 5",1==5);
	}
}