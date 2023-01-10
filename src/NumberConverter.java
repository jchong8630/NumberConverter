import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    String[] digitStr;
    int base;
    int num;

    public NumberConverter(String number, int base) {
        String numberAsString = (number);
        digits = new int[numberAsString.length()];
        this.base = base;
        digitStr = new String[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            digitStr[i] = single;
        }
        digits = convertToNum();
        for (int i = 0; i < digits.length; i++) {
            num += digits[i];
        }
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digitStr.length; i++) {
            o = o + digitStr[i];
        }
        o = o + "\n";
        return o;
    }

    public String[] getDigits() {
        return digitStr;
    }

    public int[] convertToNum() {
        String[] letters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
        for (int i = 0; i < digitStr.length; i++) {
            int count = 0;
            for (String element : letters) {
                if (element.equals(digitStr[i])) {
                    digits[i] = count;
                }
                count += 1;
//            if (digitStr[i].equals("A")){
//                digits[i] = 10;
//            }
//            else if (digitStr[i].equals("B")){
//                digits[i] = 11;
//            }
//            else if (digitStr[i].equals("C")){
//                digits[i] = 12;
//            }
//            else if (digitStr[i].equals("D")){
//                digits[i] = 13;
//            }
//            else if (digitStr[i].equals("E")){
//                digits[i] = 14;
//            }
//            else if (digitStr[i].equals("F")){
//                digits[i] = 15;
//            }
            }
        }
        return digits;
    }

    public int[] convertToDecimal() {
        int conversion = 0;
        int power = digits.length - 1;
        for (int i = 0; i < digits.length; i++) {
            conversion += digits[i] * Math.pow(base, power);
            power--;
        }
        String num = conversion + "";
        this.num = conversion;
        int [] decimal = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            String single = num.substring(i,i+1);
            decimal[i] = Integer.parseInt(single);
        }
        return decimal;
    }

    public String[] converter(int base) {
        int num = this.num;
        int count = 0;
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
        String numbers = "";
        while (num >= 1) {
            numbers = num % base + " " + numbers;
            num /= base;
        }
        int spaces = numbers.length() - numbers.replaceAll(" ", "").length();
        int[] hex = new int[spaces];
        while (numbers.length() != 0) {
            hex[count] = Integer.parseInt(numbers.substring(0, numbers.indexOf(" ")));
            numbers = numbers.substring(numbers.indexOf(" ") + 1);
            count++;
        }
        String[] hexStr = new String[hex.length];
        for (int i = 0; i < hexStr.length; i++) {
            if (hex[i] >= 10){
                hexStr[i] = letters[hex[i] - 10];
            }
            else {
                hexStr[i] = hex[i] + "";
            }
        }
        return hexStr;
    }

    public boolean inputChecker(String number){
        boolean check = true;
        if (base <= 10){
            for (int i = 0; i < number.length(); i++){
                int digit = Integer.parseInt(number.charAt(i) + "");
                if (!((digit <  base) && (digit >= 0))){
                    check = false;
                }
            }
        }
        return check;
    }
}

