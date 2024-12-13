package lotto.domain.model;

import lotto.domain.view.error.ErrorException;
import lotto.domain.view.error.InputErrorType;

public class Amount {

    public static final int AMOUNT_OF_ONE_LOTTO = 1000;
    private final int amount;
    private final int purchasedCount;

    public Amount(String amount) {
        this.amount = getValidAmount(amount);
        this.purchasedCount = calculatePurchasedCount();
    }

    public int getAmount() {
        return amount;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }

    private int getValidAmount(String input) {
        checkIfDigit(input);
        int parsedInput = Integer.parseInt(input);
        checkValidAmount(parsedInput);
        checkValidRange(parsedInput);
        return Integer.parseInt(input);
    }

    private void checkValidAmount(int input) {
        if (input % 1000 != 0) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_FORMAT);
        }
    }

    public void checkValidRange(int input) {
        if (input < 1000 || input > 1000000) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_RANGE);
        }

    }

    private void checkIfDigit(String input) throws ErrorException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new ErrorException(InputErrorType.NEED_POSITIVE_NUMBER);
            }
        }
    }

    private int calculatePurchasedCount() {
        return amount / AMOUNT_OF_ONE_LOTTO;
    }
}
