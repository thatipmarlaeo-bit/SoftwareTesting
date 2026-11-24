package เนื้อหาเรียน;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class mainTest {
    @Test
    public void testMain() {
        main obj = new main();
        assertEquals(7, obj.f);
    }
}
