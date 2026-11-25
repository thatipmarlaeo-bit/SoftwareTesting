public class GradeCalculator {
    private static final int[] MIN = {80, 75, 70, 65, 60, 55, 50};
    private static final String[] GRADE = {"A", "B+", "B", "C+", "C", "D+", "D"};

    public String gradeOf(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("score must be 0-100");
        }
        for (int i = 0; i < MIN.length; i++) {
            if (score >= MIN[i]) {
                return GRADE[i];
            }
        }
        return "F";
    }
}

