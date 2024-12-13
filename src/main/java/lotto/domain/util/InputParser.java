package lotto.domain.util;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.Lotto;
import lotto.domain.view.error.ErrorException;
import lotto.domain.view.error.InputErrorType;

public class InputParser {
    private static final String COMMA = "\\s*,\\s*";


    // 쉼표 기준으로 나누기, 나눈 게 n 개인지 검사
    public static String[] extractValidInput(String input) throws ErrorException {
        checkIsEmpty(input);
        String[] splitInput = input.split(COMMA);
        if (splitInput.length != 6) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_INPUT);
        }
        for(String parsedInput: splitInput){
            checkIsEmpty(parsedInput);
        }
        return splitInput;
    }

    // 공백 검사
    public static void checkIsEmpty(String input) throws ErrorException {
        if (input.isEmpty()) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_INPUT);
        }
    }


    public static <T> T get(Supplier<String> inputSupplier, Function<String, T> converter) {
        while (true) {
            String input = inputSupplier.get();
            try {
                return converter.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
