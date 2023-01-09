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

    public int[] convertToNum(){
        for (int i = 0; i < digitStr.length; i++){
            if (digitStr[i].equals("A")){
                digits[i] = 10;
            }
            else if (digitStr[i].equals("B")){
                digits[i] = 11;
            }
            else if (digitStr[i].equals("C")){
                digits[i] = 12;
            }
            else if (digitStr[i].equals("D")){
                digits[i] = 13;
            }
            else if (digitStr[i].equals("E")){
                digits[i] = 14;
            }
            else if (digitStr[i].equals("F")){
                digits[i] = 15;
            }
            else {
                digits[i] = Integer.parseInt(digitStr[i]);
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

