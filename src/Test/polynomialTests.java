package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.Polynomial;

public class polynomialTests {

    private Polynomial polynomial1 = new Polynomial("3*x^2-5*x^1+2");
    private Polynomial polynomial2 = new Polynomial("-7*x^2+4*x^1-3");
    
    @Test
    public void testAddition() {
        Polynomial result = polynomial1.addPolynomials(polynomial2);
        String correctResult = "-1.00 + -1.00x^1 + -4.00x^2";
        assertEquals(correctResult, result.toString());
    }
    
    @Test
    public void testSubtraction() {
        Polynomial result = polynomial1.subtractPolynomials(polynomial2);
        String correctResult = "5.00 + -9.00x^1 + 10.00x^2";
        assertEquals(correctResult, result.toString());
    }
    
    @Test
    public void testMultiplication() {
        Polynomial result = polynomial1.multiplyPolynomials(polynomial2);
        String correctResult = "-6.00 + 23.00x^1 + -43.00x^2 + 47.00x^3 + -21.00x^4";
        assertEquals(correctResult, result.toString());
    }
    
    @Test
    public void testDerivation() {
        Polynomial result = polynomial1.derivatePolynomials();
        String correctResult = "-5.00 + 6.00x^1";
        assertEquals(correctResult, result.toString());
    }
    
    @Test
    public void testIntegration() {
        Polynomial result = polynomial1.integratePolynomials();
        String correctResult = "2.00x^1 + -2.50x^2 + 1.00x^3";
        assertEquals(correctResult, result.toString());
    }
}
