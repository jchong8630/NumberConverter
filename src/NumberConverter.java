import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    int base;
    int num;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        num = number;
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int conversion = 0;
        String num = "";
        int power = digits.length - 1;
        for (int i = 0; i < digits.length; i++) {
            conversion += digits[i] * Math.pow(base, power);
            power--;
        }
        num = conversion + "";
        this.num = conversion;
        int [] decimal = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            String single = num.substring(i,i+1);
            decimal[i] = Integer.parseInt(single);
        }
        return decimal;
    }

    public int [] convertToBinary() {
        int num = this.num;
        String numbers = "";
        if (base == 2){
            return digits;
        }
        while (num > 1){
            numbers = num % 2 + "" + numbers;
            num /= 2;
        }
        if (num == 1){
            numbers = 1 + "" + numbers;
        }
        int [] binary = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            String single = numbers.substring(i,i+1);
            binary[i] = Integer.parseInt(single);
        }
        return binary;
    }

    public int[] convertToOctal() {
        int num = this.num;
        String numbers = "";
        while (num >= 1){
            numbers = num % 8 + "" + numbers;
            num /= 8;
        }
        int [] octal = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            String single = numbers.substring(i,i+1);
            octal[i] = Integer.parseInt(single);
        }
        return octal;
    }

    public String[] convertToHex() {
        int num = this.num;
        int count = 0;
        String numbers = "";
        while (num >= 1){
            numbers = num % 16 + " " + numbers;
            num /= 16;
        }
        int spaces =numbers.length() -  numbers.replaceAll(" ", "").length();
        int[] hex = new int[spaces];
        while (numbers.length() != 0){
            hex[count] = Integer.parseInt(numbers.substring(0,numbers.indexOf(" ")));
            numbers = numbers.substring(numbers.indexOf(" ") + 1);
            count++;
        }
        String[] hexStr = new String[hex.length];
        for (int i = 0; i < hexStr.length; i++){
            if (hex[i] == 10){
                hexStr[i] = "A";
            }
            else if (hex[i] == 11){
                hexStr[i] = "B";
            }
            else if (hex[i] == 12){
                hexStr[i] = "C";
            }
            else if (hex[i] == 13){
                hexStr[i] = "D";
            }
            else if (hex[i] == 14){
                hexStr[i] = "E";
            }
            else if (hex[i] == 15){
                hexStr[i] = "F";
            }
            else{
                hexStr[i] = hex[i] + "";
            }
        }
        return hexStr;
    }
}

