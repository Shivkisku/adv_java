public class Operations {
    /* Flip a positive sign to negative or a negative sign to positive */
    public static int negate(int a) {
        int neg = 0;
        int d = a < 0 ? 1 : -1;
        while (a != 0) {
            neg += d;
            a += d;
        }
        return neg;
    }

    /* Subtract two numbers by negating b and adding them */
    public static int minus(int a, int b) {
        return a + negate(b);
    }

    /* Multiply a by b by adding a to itself b times */
    public static int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a); // Algorithm is faster if b < a
        }
        int sum = 0;
        for (int i = abs(b); i > 0; i--) {
            sum += a;
        }
        if (b < 0) {
            sum = negate(sum);
        }
        return sum;
    }

    /* Return absolute value */
    public static int abs(int a) {
        if (a < 0) {
            return negate(a);
        } else {
            return a;
        }
    }

    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new java.lang.ArithmeticException("ERROR: Division by zero");
        }
        int absa = abs(a);
        int absb = abs(b);

        int product = 0;
        int x = 0;
        while (product + absb <= absa) { // Don't go past a
            product += absb;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return negate(x);
        }
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 2;

        int additionResult = a + b;
        int subtractionResult = minus(a, b);
        int multiplicationResult = multiply(a, b);
        int divisionResult = divide(a, b);

        System.out.println("Addition: " + additionResult);
        System.out.println("Subtraction: " + subtractionResult);
        System.out.println("Multiplication: " + multiplicationResult);
        System.out.println("Division: " + divisionResult);
    }
}


// javac Operations.java
// java Operations
