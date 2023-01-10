import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number: ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (!isNumeric(choice) || (Integer.parseInt(choice) <= 1)){
                System.out.print("Enter a valid base: ");
                choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);


        System.out.print("Enter your number: ");
        String number = s.nextLine();

        System.out.print("Enter base you want to convert to: ");
        int convert = s.nextInt();

        s.close();

        NumberConverter nc = new NumberConverter(number, base);
        if (nc.inputChecker(number)){
            String[] digits = nc.getDigits();
            System.out.println("\n\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + nc.displayOriginalNumber());
            nc.convertToDecimal();
            System.out.println("Conversion: " +  Arrays.toString(nc.converter(convert)));
            System.out.println("Binary: " + Arrays.toString(nc.converter(2)));
            System.out.println("Octal: " + Arrays.toString(nc.converter(8)));
            System.out.println("Hex: " + Arrays.toString(nc.converter(16)));
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

