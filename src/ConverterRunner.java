import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number: ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (!isNumeric(choice) || (Integer.parseInt(choice) <= 1 || (Integer.parseInt(choice) > 64))){
                System.out.print("Enter a valid base: ");
                choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);


        System.out.print("Enter your number: ");
        String number = s.nextLine();
        while (!NumberConverter.inputChecker(number, base)){
            System.out.print("Enter a valid number: ");
            number = s.nextLine();
        }

        System.out.print("Enter base you want to convert to: ");
        int convert = s.nextInt();
        while (convert < 2 || convert > 64){
            System.out.print("Enter a valid base12: ");
            convert = s.nextInt();
        }

        s.close();

        NumberConverter nc = new NumberConverter(number, base);
            String[] digits = nc.getDigits();
            System.out.println("\n\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + nc.displayOriginalNumber());
            nc.convertToDecimal();
            System.out.println("Conversion: " +  nc.converter(convert));
            System.out.println("\nDecimal: " + nc.converter(10));
            System.out.println("Binary: " + nc.converter(2));
            System.out.println("Octal: " + nc.converter(8));
            System.out.println("Hex: " + nc.converter(16));
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

