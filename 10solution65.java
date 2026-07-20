class Solution {
    public boolean isNumber(String s) {

        boolean digit = false;
        boolean dot = false;
        boolean exp = false;
        boolean digitAfterExp = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If digit
            if (ch >= '0' && ch <= '9') {
                digit = true;

                if (exp) {
                    digitAfterExp = true;
                }
            }

            // If decimal point
            else if (ch == '.') {

                // Dot not allowed after exponent or multiple dots
                if (dot || exp) {
                    return false;
                }

                dot = true;
            }

            // If exponent
            else if (ch == 'e' || ch == 'E') {

                // Exponent needs a number before it
                if (exp || !digit) {
                    return false;
                }

                exp = true;
                digitAfterExp = false;
            }

            // If sign + or -
            else if (ch == '+' || ch == '-') {

                // Sign allowed only at start or after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' 
                          && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Other characters
            else {
                return false;
            }
        }

        return digit && digitAfterExp;
    }
}