import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GradeCalculatorTest {

    private GradeCalculator calc;

    @Before
    public void setUp() {
        calc = new GradeCalculator();
    }


    @Test
    public void ep_validGrades_midRange() {
        assertEquals("A", calc.gradeOf(90));   // GC-01
        assertEquals("B+", calc.gradeOf(77));  // GC-02
        assertEquals("B", calc.gradeOf(72));   // GC-03
        assertEquals("C+", calc.gradeOf(67));  // GC-04
        assertEquals("C", calc.gradeOf(62));   // GC-05
        assertEquals("D+", calc.gradeOf(57));  // GC-06
        assertEquals("D", calc.gradeOf(52));   // GC-07
        assertEquals("F", calc.gradeOf(25));   // GC-08
    }

    @Test
    public void ep_negativeScore_throwsException() {
        // GC-09
        assertThrows(IllegalArgumentException.class, () -> calc.gradeOf(-20));
    }

    @Test
    public void ep_scoreAboveHundred_throwsException() {
        // GC-10
        assertThrows(IllegalArgumentException.class, () -> calc.gradeOf(150));
    }

    // ==========================================
    // 2. กลุ่ม BVA (Boundary Value Analysis)
    // ==========================================

    @Test
    public void bva_gradeA_boundaries() {
        assertEquals("A", calc.gradeOf(80));   // GC-11 (ขอบล่าง A)
        assertEquals("A", calc.gradeOf(100));  // GC-12 (ขอบบน A)
    }

    @Test
    public void bva_gradeBPlus_boundaries() {
        assertEquals("B+", calc.gradeOf(75));  // GC-13 (ขอบล่าง B+)
        assertEquals("B+", calc.gradeOf(79));  // GC-14 (ขอบบน B+)
    }

    @Test
    public void bva_gradeB_boundaries() {
        assertEquals("B", calc.gradeOf(70));   // GC-15 (ขอบล่าง B)
        assertEquals("B", calc.gradeOf(74));   // GC-16 (ขอบบน B)
    }

    @Test
    public void bva_gradeCPlus_boundaries() {
        assertEquals("C+", calc.gradeOf(65));  // GC-17 (ขอบล่าง C+)
        assertEquals("C+", calc.gradeOf(69));  // GC-18 (ขอบบน C+)
    }

    @Test
    public void bva_gradeC_boundaries() {
        assertEquals("C", calc.gradeOf(60));   // GC-19 (ขอบล่าง C)
        assertEquals("C", calc.gradeOf(64));   // GC-20 (ขอบบน C)
    }

    @Test
    public void bva_gradeDPlus_boundaries() {
        assertEquals("D+", calc.gradeOf(55));  // GC-21 (ขอบล่าง D+)
        assertEquals("D+", calc.gradeOf(59));  // GC-22 (ขอบบน D+)
    }

    @Test
    public void bva_gradeD_boundaries() {
        assertEquals("D", calc.gradeOf(50));   // GC-23 (ขอบล่าง D)
        assertEquals("D", calc.gradeOf(54));   // GC-24 (ขอบบน D)
    }

    @Test
    public void bva_gradeF_boundaries() {
        assertEquals("F", calc.gradeOf(0));    // GC-25 (ขอบล่าง F)
        assertEquals("F", calc.gradeOf(49));   // GC-26 (ขอบบน F)
    }

    @Test
    public void bva_justBelowZero_throwsException() {
        // GC-27 (ขอบติดลบ)
        assertThrows(IllegalArgumentException.class, () -> calc.gradeOf(-1));
    }

    @Test
    public void bva_justAboveHundred_throwsException() {
        // GC-28 (ขอบเกิน 100)
        assertThrows(IllegalArgumentException.class, () -> calc.gradeOf(101));
    }

    // ==========================================
    // 3. กลุ่ม Error Guessing (ค่าสุดขีดของ int)
    // ==========================================

    @Test
    public void errorGuessing_intExtremeValues_throwsException() {
        // GC-29
        assertThrows(IllegalArgumentException.class, () -> calc.gradeOf(Integer.MIN_VALUE));
        assertThrows(IllegalArgumentException.class, () -> calc.gradeOf(Integer.MAX_VALUE));
    }
}
