public class InputParser {
    static final int MIN_ELEMENTS = 3;
    static final int MIN_OPERAND = 1;
    static final int MAX_OPERAND = 10;

    public static String[] parseInput (String input) throws InputValidationException {
        String[] elements = input.split(" ");
        validateElementList(elements);
        validateElements(elements);
        return elements;
    }

    public static void validateElementList(String[] elements) throws InputValidationException{
        if (elements.length < MIN_ELEMENTS) {
            throw new InputValidationException(
                    String.format("Expression must contain at least %d elements.", MIN_ELEMENTS)
            );
        }
    }

    public static void validateElements(String[] elements) throws InputValidationException {
        int operandCount = 0;
        int operatorCount = 0;
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            if (i % 2 == 0) {
                validateOperand(element);
                operandCount++;
            } else {
                validateOperator(element);
                operatorCount++;
            }
        }
        if (operatorCount + 1 != operandCount) {
            throw new InputValidationException("Invalid amount of operators and operands.");
        }
    }

    public static void validateOperand(String operand) throws InputValidationException {
        int intOperand = Integer.parseInt(operand);
        if (intOperand > MAX_OPERAND || intOperand < MIN_OPERAND) {
            throw new InputValidationException(String.format("Operand %d is out of supported range.", intOperand));
        }
    }

    public static void validateOperator (String operator) throws InputValidationException {
        for (int i = 0; i < ConstantUtil.OPERATORS.length; i++) {
            if (ConstantUtil.OPERATORS[i].equals(operator)) {
                return;
            }
        }
        throw new InputValidationException(String.format("Operator %s is out of supported range.", operator));
    }
}
