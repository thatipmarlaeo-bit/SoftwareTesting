package เนื้อหาเรียน;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;

public class calculatorTest {

    private calculator obj;

        @BeforeClass 
        public void setUp() {
            obj = new calculator();
        }
        
        @Test
        public void testCalculator() {
            assertEquals(5, obj.addNumbers(2, 3));
        }

        @Test 
        public void testCalculatorDivide() {
            assertEquals(2, obj.divide(10, 5));
        }
}
