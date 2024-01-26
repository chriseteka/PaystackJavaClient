package io.github.chriseteka.paystackclient.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public final class Amount {
    private static final BigDecimal UNIT_CONSTANT = BigDecimal.valueOf(100);
    private final MoneyValue value;
    private final Currency currency;

    private Amount(Currency currency, MoneyValue moneyValue) {
        this.currency = currency;
        this.value = moneyValue;
    }

    public static MoneyValue unitValue(BigDecimal value) {
        return new MoneyValue(value.divide(UNIT_CONSTANT, 2, RoundingMode.FLOOR), value);
    }

    public static MoneyValue actualValue(BigDecimal value) {
        return new MoneyValue(value, value.multiply(UNIT_CONSTANT));
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getUnitValue() {
        return value.unitValue.toPlainString();
    }

    public String getActualValue() {
        return value.actualValue.toPlainString();
    }

    public record MoneyValue(BigDecimal actualValue, BigDecimal unitValue) {

        public MoneyValue(BigInteger unitValue) {
            this(BigDecimal.valueOf(unitValue.longValue()));
        }
        private MoneyValue(BigDecimal unitValue) {
            this(unitValue.divide(UNIT_CONSTANT, 2, RoundingMode.FLOOR), unitValue);
        }

        public Amount ofCurrency(Currency currency) {
            return new Amount(currency, this);
        }
    }
}
