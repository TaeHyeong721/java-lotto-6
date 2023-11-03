package lotto.domain;

import lotto.util.ErrorMessage;

public record Money(int amount) {

    private static final int MAX_PURCHASE_AMOUNT = 100000;

    public Money {
        validateAmountMultipleOfThousand(amount);
        validateMaximumAmount(amount);
    }

    public Money(String amount) {
        this(parseAmount(amount));
    }

    private static int parseAmount(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validateMaximumAmount(int amount) {
        if (amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_GREATER_THAN_MAXIMUM.getMessage());
        }
    }

    private void validateAmountMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }
}
