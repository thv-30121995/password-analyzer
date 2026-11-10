public class passwordtrengthresult {
    public final int score;
    public final double entropy;
    public final String label;
    public final boolean hasUpper, hasLower, hasDigit, hasSpecial;

    public passwordtrengthresult(int score, double entropy, String label,
            boolean hasUpper, boolean hasLower, boolean hasDigit, boolean hasSpecial) {
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
