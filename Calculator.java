import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Input:");
        Scanner scan = new Scanner(System.in);
        String[] elements = InputParser.parseInput(scan.nextLine());

        for (String operator : ConstantUtil.OPERATORS) {
            for (int i = 1; i < elements.length; i+=2) {
                if (elements[i].equals(operator)) {
                    int result = calculate(elements[i-1], elements[i], elements[i+1]);
                    elements[i-1] = Integer.toString(result);
                    elements = removeListElements(elements, i, i+1);
                }
            }
        }
        System.out.printf("Output:%n%s%n", elements[0]);
    }

    public static String[] removeListElements(String[] elements, int fromIndex, int toIndex) {
        String[] updatedList = new String[elements.length - 1 - toIndex + fromIndex];
        int emptyIndex = 0;
        for (int i = 0; i < elements.length; i++) {
            if (i < fromIndex || i > toIndex) {
                updatedList[emptyIndex] = elements[i];
                emptyIndex++;
            }
        }
        return updatedList;
    }

    public static int calculate(String value1, String operator, String value2) {
        int num1 = Integer.parseInt(value1);
        int num2 = Integer.parseInt(value2);
        int result;
        switch (operator) {
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
            case "-":
                result = subtract(num1, num2);
                break;
            default:
                result = add(num1, num2);
                break;
        }
        return result;
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        return num1 / num2;
    }

}
