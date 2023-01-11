import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    String[] digitStr;
    int base;
    int num;

    public NumberConverter(String number, int base) {
        digits = new int[number.length()];
        this.base = base;
        digitStr = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String single = number.substring(i, i + 1);
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
        int[] convert = new int[spaces];
        while (numbers.length() != 0) {
            convert[count] = Integer.parseInt(numbers.substring(0, numbers.indexOf(" ")));
            numbers = numbers.substring(numbers.indexOf(" ") + 1);
            count++;
        }
        String[] convertStr = new String[convert.length];
        for (int i = 0; i < convertStr.length; i++) {
            if (convert[i] >= 10){
                convertStr[i] = letters[convert[i] - 10];
            }
            else {
                convertStr[i] = convert[i] + "";
            }
        }
        return convertStr;
    }

    public static boolean inputChecker(String number, int base){
        boolean check = true;
        String[] letters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
        for (int i = 0; i < number.length(); i++){
            String element = number.charAt(i) + "";
            for (int j = base; j < letters.length; j++) {
                if (element.equals(letters[j])) {
                    check = false;
                }
            }
        }
        return check;
    }
}

