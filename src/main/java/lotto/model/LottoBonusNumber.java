package lotto.model;

import java.util.Objects;
import lotto.view.error.ErrorType;
import lotto.view.error.InputErrorException;

public class LottoBonusNumber {

    public static final String WHITE_SPACE_REGEX = "\\s";

    public static final String EMPTY_STRING = "";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private Integer bonusNumber;
    private Lotto lotto;

    public LottoBonusNumber(String bonusNumber, Lotto lotto) {
        this.lotto = lotto;
        this.bonusNumber = getValidBonusNumber(bonusNumber);
    }

    public Integer getLottoBonusNumber() {
        return bonusNumber;
    }

    public Integer getValidBonusNumber(String bonusNumbers) {
        String trimmedLottoNumbers = bonusNumbers.trim();
        checkIfEmpty(trimmedLottoNumbers);

        validateOnlyDigit(bonusNumbers);

        Integer parsedBonusNumber = parseInt(bonusNumbers);

        checkValidRange(parsedBonusNumber);
        checkDuplicatedNumber(parsedBonusNumber);

        return parsedBonusNumber;
    }

    private void checkDuplicatedNumber(Integer bonusNumber) {
        lotto.getLottoNumbers().forEach(lottoNumber -> {
            if (lottoNumber.equals(bonusNumber)) {
                throw new InputErrorException(ErrorType.NEED_DISTINCT_NUMBER);
            }
        });
    }


    private static void checkValidRange(Integer bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new InputErrorException(ErrorType.NEED_NUMBER_IN_RANGE);
        }
    }


    private void validateOnlyDigit(String bonusNumber) {
        checkIfEmpty(bonusNumber);
        checkIfDigit(bonusNumber);
    }

    private void checkIfEmpty(String input) {
        if (input.isEmpty()) {
            throw new InputErrorException(ErrorType.NEED_NOT_EMPTY);
        }
        if (input.replaceAll(WHITE_SPACE_REGEX, EMPTY_STRING).isEmpty()) {
            throw new InputErrorException(ErrorType.NEED_NOT_EMPTY);
        }
    }

    private void checkIfDigit(String bonusNumber) {
        for (int i = 0; i < bonusNumber.length(); i++) {
            if (!Character.isDigit(bonusNumber.charAt(i))) {
                throw new InputErrorException(ErrorType.NEED_NUMBER);
            }
        }
    }

    private int parseInt(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new InputErrorException(ErrorType.NEED_INTEGER);
        }
    }
}
