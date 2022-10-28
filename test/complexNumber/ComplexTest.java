package complexNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {
        private Complex firstComplex;
        private Complex secondComplex;

        @BeforeEach
        void setUp(){
            firstComplex = new Complex(4,8);
            secondComplex = new Complex(3,5);
        }
        @Test
        void testThatComplexNumbersCanBeAddedTogether(){
            Complex addNumber = Complex.addComplexNumber(firstComplex,secondComplex);
            assertEquals(new Complex(7,13), addNumber);
        }

    @Test
    void testThatComplexNumbersCanBeSubtracted(){
        Complex subNumber = Complex.subtractComplexNumber(firstComplex,secondComplex);
        assertEquals(new Complex(-1,-3), subNumber);
    }
}