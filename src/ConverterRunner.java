import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (!isNumeric(choice)){
                System.out.print("Enter a valid base: ");
                choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);


        System.out.print("Enter your number: ");
        String number = s.nextLine();

        s.close();

        NumberConverter nc = new NumberConverter(number, base);
        if (nc.inputChecker(number)){
            String[] digits = nc.getDigits();
            System.out.println("\n\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + nc.displayOriginalNumber());

            System.out.println("Decimal: " + Arrays.toString(nc.convertToDecimal()));
            System.out.println("Binary: " + Arrays.toString(nc.convertToBinary()));
            System.out.println("Octal: " + Arrays.toString(nc.convertToOctal()));
            System.out.println("Hex: " + Arrays.toString(nc.convertToHex()));
        }
        else{
            System.out.println("Invalid number");
        }

    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

