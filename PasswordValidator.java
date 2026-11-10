import java.util.regex.Pattern;

public class PasswordValidator {

    public static StrengthResult analyzePassword(String password) {
        if (password == null) {
            password = "";
        }

        int score = 0;
        int length = password.length();

        // 1. Structural Checks via Regular Expressions
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLower = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?~`|\\\\]").matcher(password).find();

        if (length >= 8) score++;
        if (length >= 12) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        int poolSize = 0;
        if (hasLower) poolSize += 26;
        if (hasUpper) poolSize += 26;
        if (hasDigit) poolSize += 10;
        if (hasSpecial) poolSize += 32;

        double entropy = 0;
        if (poolSize > 0 && length > 0) {
            entropy = length * (Math.log(poolSize) / Math.log(2));
        }

        String label;
        if (length < 8 || score <= 2) {
            label = "WEAK";
        } else if (score <= 4) {
            label = "MEDIUM";
        } else if (score <= 5) {
            label = "STRONG";
        } else {
            label = "VERY STRONG / EXCELLENT";
        }

        return new StrengthResult(score, entropy, label, hasUpper, hasLower, hasDigit, hasSpecial);
    }

    public static class StrengthResult {
        private final int score;
        private final double entropy;
        private final String label;
        private final boolean hasUpper;
        private final boolean hasLower;
        private final boolean hasDigit;
        private final boolean hasSpecial;

        public StrengthResult(int score, double entropy, String label,
                             boolean hasUpper, boolean hasLower,
                             boolean hasDigit, boolean hasSpecial) {
            this.score = score;
            this.entropy = entropy;
            this.label = label;
            this.hasUpper = hasUpper;
            this.hasLower = hasLower;
            this.hasDigit = hasDigit;
            this.hasSpecial = hasSpecial;
        }

        public int getScore() {
            return score;
        }

        public double getEntropy() {
            return entropy;
        }

        public String getLabel() {
            return label;
        }

        public boolean hasUpper() {
            return hasUpper;
        }

        public boolean hasLower() {
            return hasLower;
        }

        public boolean hasDigit() {
            return hasDigit;
        }

        public boolean hasSpecial() {
            return hasSpecial;
        }
    }
}
