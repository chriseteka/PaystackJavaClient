package com.chrisworks.paystackclient.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Amount {

    private final MoneyValue value;
    private final Currency currency;

    public Amount(Currency currency, BigDecimal value, boolean isAlreadyInUnitValue) {
        this.currency = currency;
        this.value = isAlreadyInUnitValue ? MoneyValue.fromUnitValue(value) : MoneyValue.fromActualValue(value);
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

    public static final class MoneyValue {

        private static final BigDecimal UNIT_CONSTANT = BigDecimal.valueOf(100);
        private final BigDecimal actualValue;
        private final BigDecimal unitValue;

        private MoneyValue(BigDecimal actualValue, BigDecimal unitValue) {
            this.actualValue = actualValue;
            this.unitValue = unitValue;
        }

        private static MoneyValue fromUnitValue(BigDecimal value) {
            return new MoneyValue(value.divide(UNIT_CONSTANT, 2, RoundingMode.FLOOR), value);
        }

        private static MoneyValue fromActualValue(BigDecimal value) {
            return new MoneyValue(value, value.multiply(UNIT_CONSTANT));
        }
    }
}
