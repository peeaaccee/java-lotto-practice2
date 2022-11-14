package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int inputLottoAmount() {
        OutputView.printInputAmount();
        String money = Console.readLine();
        return Integer.parseInt(money);
    }


    public static List<Integer> inputWinningNumbers() {
        OutputView.printWinningNumbers();
        String numberInput = Console.readLine();
        System.out.println(numberInput);
        String[] numbers = numberInput.split(",");
        List<String> numberList = new ArrayList<>(List.of(numbers));

        List<Integer> winningNumbers = numberList.stream()
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public static int inputBonusNumber() {
        OutputView.printBonusNumber();
        String bonusNumber = Console.readLine();
        System.out.println(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}

// 필요한 부분 validate 추가
