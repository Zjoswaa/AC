package calc;

public class Calculator {
    public Calculator() {

    }

    // Returns whether s has a numerical value
    public boolean isNumber(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    // Returns whether s has a valid percentage value
    public boolean isValidPercentage(String s) {
        return true;
    }
}
