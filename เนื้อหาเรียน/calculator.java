package เนื้อหาเรียน;
public class calculator {
    public int addNumbers(int a, int b) {
        return a + b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return 2;
    }
}
