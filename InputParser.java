public class InputParser {
    static final int MIN_ELEMENTS = 3;
    static final int MIN_OPERAND = 1;
    static final int MAX_OPERAND = 10;

    public static String[] parseInput (String input) throws Exception {
        String[] elements = input.split(" ");
        validateElementList(elements);
        validateElements(elements);
        return elements;
    }

    public static void validateElementList(String[] elements) throws Exception{
        if (elements.length < MIN_ELEMENTS) {
            throw new Exception(
                    String.format("Expression must contain at least %d elements.", MIN_ELEMENTS)
            );
        }
    }

    public static void validateElements(String[] elements) throws Exception {
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            if (i % 2 == 0) {
                validateOperand(element);
            } else {
                validateOperator(element);
            }
        }
    }

    public static void validateOperand(String operand) throws Exception {
        int intOperand = Integer.parseInt(operand);
        if (intOperand > MAX_OPERAND || intOperand < MIN_OPERAND) {
            throw new Exception(String.format("Operand %d is out of supported range.", intOperand));
        }
    }

    public static void validateOperator (String operator) throws Exception {
        for (int i = 0; i < ConstantUtil.OPERATORS.length; i++) {
            if (ConstantUtil.OPERATORS[i].equals(operator)) {
                return;
            }
        }
        throw new Exception(String.format("Operator %s is out of supported range.", operator));
    }
}