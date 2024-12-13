package lotto.domain.view.error;

public enum InputErrorType {

    ERROR_MESSAGE("[ERROR] "),
    NEED_AVAILABLE_FORMAT("1000단위의 숫자를 입력해야 합니다."),
    NEED_AVAILABLE_RANGE("1000이상 1000000이하의 숫자를 입력해야 합니다."),
    NEED_AVAILABLE_LOTTO_NUMBER_RANGE("1부터 45 사이의 숫자를 입력해야 합니다."),
    NEED_AVAILABLE_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    NEED_POSITIVE_NUMBER("양수를 입력해야 합니다."),
    NEED_UNIQUE_NUMBER("중복이 아닌 숫자를 입력해야 합니다."),
    NEED_AVAILABLE_INPUT("잘못된 입력입니다."),
    NEED_REENTER_INPUT(" 다시 입력해 주세요."),
    NEED_DISTINCT_NUMBER("로또 번호는 중복되지 않은 6개의 숫자를 입력해야 합니다.");

    final String message;

    InputErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
