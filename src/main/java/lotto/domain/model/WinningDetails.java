package lotto.domain.model;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WinningDetails {

    private static final String newline = System.getProperty("line.separator");

    private Map<PrizeMoney, Integer> winningDetails = new LinkedHashMap<>();

    public WinningDetails() {
        winningDetails.put(PrizeMoney.ZERO, 0);
        winningDetails.put(PrizeMoney.THREE, 0);
        winningDetails.put(PrizeMoney.FOUR, 0);
        winningDetails.put(PrizeMoney.FIVE, 0);
        winningDetails.put(PrizeMoney.FIVE_WITH_BONUS, 0);
        winningDetails.put(PrizeMoney.SIX, 0);
    }

    public void update(PrizeMoney prizeMoney) {
        Integer count = winningDetails.get(prizeMoney);
        winningDetails.put(prizeMoney, count + 1);
    }

    public String display() {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("###,###");

        for (Entry<PrizeMoney, Integer> entrySet : winningDetails.entrySet()) {
            if (entrySet.getKey() == PrizeMoney.ZERO) {
                continue;
            }
            result.append(entrySet.getKey().getMatchedCount()).append("개 일치");
            if (entrySet.getKey() == PrizeMoney.FIVE_WITH_BONUS) {
                result.append(", 보너스 볼 일치");
            }
            result.append(" (");
            String formattedPrizeMoney = df.format(entrySet.getKey().getPrizeMoney());
            result.append(formattedPrizeMoney);
            result.append("원) ");
            result.append("- ").append(entrySet.getValue()).append("개").append(newline);
        }
        return result.toString();
    }

    public int getTotalPrize() {
        int totalPrizeMoney = 0;
        for (Entry<PrizeMoney, Integer> entrySet : winningDetails.entrySet()) {
            totalPrizeMoney += entrySet.getKey().getPrizeMoney() * entrySet.getValue();
        }
        return totalPrizeMoney;
    }
}
