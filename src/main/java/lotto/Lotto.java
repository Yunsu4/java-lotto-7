package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.view.error.ErrorException;
import lotto.domain.view.error.InputErrorType;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String display() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }

    public void checkDuplicate(Integer bonusNumber) {
        numbers.forEach(lottoNumber -> {
            if (lottoNumber.equals(bonusNumber)) {
                throw new ErrorException(InputErrorType.NEED_UNIQUE_NUMBER);
            }
        });
    }

    public int getMatchedCount(Lotto inputLotto) {
        List<Integer> inputs = inputLotto.getNumbers();
        Set<Integer> inputSet = new HashSet<>(inputs);

        int matchedCount = 0;
        for (int number : numbers) {
            if (inputSet.contains(number)) {
                matchedCount++;
            }
        }

        return matchedCount;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_LOTTO_COUNT);
        }
        checkValidRange(numbers);
        checkDuplicate(numbers);
    }

    private void checkValidRange(List<Integer> input) {
        input.forEach(lottoNumber -> {
            if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
                throw new ErrorException(InputErrorType.NEED_AVAILABLE_LOTTO_NUMBER_RANGE);
            }
        });

    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> distinctLottoNumbers = new HashSet<>();

        for (Integer lottoNumber : numbers) {
            if (!distinctLottoNumbers.add(lottoNumber)) {
                throw new ErrorException(InputErrorType.NEED_DISTINCT_NUMBER);
            }
        }
    }
}
