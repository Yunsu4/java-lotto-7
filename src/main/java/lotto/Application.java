package lotto;

import lotto.domain.controller.FrontController;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        FrontController frontController = new FrontController(inputView, outputView);
        frontController.run();
    }
}
