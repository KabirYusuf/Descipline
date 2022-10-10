package complexNumber;

public class Main {
    public static void main(String[] args) {
        Complex firstComplex = new Complex(2,6);
        Complex secondComplex = new Complex(8,3);
        Complex.printComplexNumbers(firstComplex,secondComplex);

        System.out.println(Complex.addComplexNumber(firstComplex,secondComplex));
        System.out.println(Complex.subtractComplexNumber(firstComplex,secondComplex));
    }
}
