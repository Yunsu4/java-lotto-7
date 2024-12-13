package lotto.domain.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.model.Amount;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.PrizeMoney;
import lotto.domain.model.WinningDetails;
import lotto.domain.util.InputParser;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;
import lotto.domain.view.error.ErrorException;
import lotto.domain.view.error.InputErrorType;

public class FrontController {

    private final InputView inputView;
    private final OutputView outputView;

    public FrontController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Amount amount = InputParser.get(inputView::enteredPurchaseAmount, Amount::new);
        int purchasedCount = amount.getPurchasedCount();
        outputView.printPurchasedLottoCount(purchasedCount);

        List<Lotto> generatedLottos = getGeneratedLottos(purchasedCount);
        displayGeneratedLottos(generatedLottos);

        Lotto enteredLotto = getValidEnteredLotto();
        BonusNumber bonusNumber = getValidBonusNumber(enteredLotto);

        WinningDetails winningDetails = matchLottos(generatedLottos, enteredLotto, bonusNumber);
        outputView.printWinningDetails(winningDetails.display());

        float yield = calculateYield(winningDetails, amount.getAmount());
        outputView.printYield(yield);
    }

    private float calculateYield(WinningDetails winningDetails, int purchasedAmount) {
        int totalPrizeMoney = winningDetails.getTotalPrize();
        return (float) totalPrizeMoney / purchasedAmount * 100;
    }

    private WinningDetails matchLottos(List<Lotto> generatedLottos, Lotto enteredLotto, BonusNumber bonusNumber) {
        WinningDetails winningDetails = new WinningDetails();

        for (Lotto generatedLotto : generatedLottos) {
            int matchedCount = generatedLotto.getMatchedCount(enteredLotto);
            if (matchedCount <= 2) {
                matchedCount = 0;
            }
            boolean isBonusNumberMatched = isBonusNumberMatched(bonusNumber, generatedLotto, matchedCount);
            PrizeMoney prize = PrizeMoney.getPrizeMoney(isBonusNumberMatched, matchedCount);
            winningDetails.update(prize);
        }
        return winningDetails;
    }

    private boolean isBonusNumberMatched(BonusNumber bonusNumber, Lotto generatedLotto, int matchedCount) {
        if (matchedCount == 5) {
            return bonusNumber.ifMatch(generatedLotto);
        }
        return false;
    }

    private void displayGeneratedLottos(List<Lotto> generatedLottos) {
        for (Lotto lotto : generatedLottos) {
            String oneLotto = lotto.display();
            outputView.printLotto(oneLotto);
        }
    }

    private List<Lotto> getGeneratedLottos(int purchasedCount) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < purchasedCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            generatedLottos.add(lotto);
        }
        return generatedLottos;
    }

    private Lotto getValidEnteredLotto() {
        String input = inputView.enteredWinningNumbers();
        try {
            String[] splitInput = InputParser.extractValidInput(input);
            List<Integer> lottoNumbers = getParsedInput(splitInput);
            return new Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidEnteredLotto();
        }
    }

    private List<Integer> getParsedInput(String[] inputs) throws ErrorException {
        List<Integer> parsedInput = new ArrayList<>();
        for (String input : inputs) {
            checkIfDigit(input);
            parsedInput.add(Integer.parseInt(input));
        }
        return parsedInput;
    }

    private void checkIfDigit(String input) throws ErrorException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new ErrorException(InputErrorType.NEED_POSITIVE_NUMBER);
            }
        }
    }

    private BonusNumber getValidBonusNumber(Lotto lotto) {
        String input = inputView.enteredBonusNumber();
        try {
            return new BonusNumber(input, lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidBonusNumber(lotto);
        }
    }


}
