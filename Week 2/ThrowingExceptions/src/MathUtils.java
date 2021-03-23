
// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils {
//-------------------------------------------------------------
// Returns the factorial of the argument given
//-------------------------------------------------------------
	public static int factorial(int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException("\nError! A negative number detected, it should be more than 0");
		}
		else if (n > 16) {
			throw new IllegalArgumentException("\nError! A large number detected, it should be less than 17");
		}
		else {
			int fac = 1;
			for (int i=n; i>0; i--) {

				fac *= i;
			}
			return fac;
			}
		}
	 }