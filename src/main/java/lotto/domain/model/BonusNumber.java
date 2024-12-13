package lotto.domain.model;

import lotto.Lotto;
import lotto.domain.util.InputParser;
import lotto.domain.view.error.ErrorException;
import lotto.domain.view.error.InputErrorType;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input, Lotto lotto) {
        this.number = getValidNumber(input, lotto);
    }

    public int getNumber() {
        return number;
    }

    private int getValidNumber(String input, Lotto lotto) {
        InputParser.checkIsEmpty(input);
        checkIfDigit(input);
        int parsedInput = Integer.parseInt(input);

        lotto.checkDuplicate(parsedInput);
        return parsedInput;
    }

    public boolean ifMatch(Lotto lotto) {
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (lottoNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }

    private void checkIfDigit(String input) throws ErrorException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new ErrorException(InputErrorType.NEED_POSITIVE_NUMBER);
            }
        }
    }
}
