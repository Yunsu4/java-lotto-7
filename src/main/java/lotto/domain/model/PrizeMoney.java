package lotto.domain.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import lotto.domain.view.error.ErrorException;
import lotto.domain.view.error.InputErrorType;

public enum PrizeMoney {
    ZERO(false, 0,0),
    THREE(false, 3, 5000),
    FOUR(false, 4, 50000),
    FIVE(false, 5, 1500000),
    FIVE_WITH_BONUS(true, 5, 30000000),
    SIX(false, 6, 2000000000);

    final boolean isBonusMatched;
    final int matchedCount;
    final int prizeMoney;

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    PrizeMoney(boolean isBonusMatched, int matchedCount, int prizeMoney) {
        this.isBonusMatched = isBonusMatched;
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
    }

    public static PrizeMoney getPrizeMoney(boolean enteredIsBonusMatched, int enteredMatchedCount) throws ErrorException{
        return Arrays.stream(PrizeMoney.values())
                .filter(prize -> Objects.equals(prize.isBonusMatched, enteredIsBonusMatched))
                .filter(prize -> Objects.equals(prize.matchedCount, enteredMatchedCount))
                .findAny()
                .orElseThrow(() -> new ErrorException(InputErrorType.NEED_AVAILABLE_INPUT));
    }

}
