package lotto.domain.view;

public class OutputView {

    private static final String newline = System.getProperty("line.separator");

    public void printPurchasedLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLotto(String lotto) {
        System.out.println(lotto);
    }

    public void printWinningDetails(String winningDetails) {
        System.out.println(newline + "당첨 통계" + newline + "---"
                + newline + winningDetails);
    }

    public void printYield(float yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

}
