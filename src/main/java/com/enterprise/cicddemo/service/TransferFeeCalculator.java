
package com.enterprise.cicddemo.service;

import java.math.BigDecimal;

public class TransferFeeCalculator {

    public BigDecimal calculateFee(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Transfer amount must be greater than zero"
            );
        }

        if (amount.compareTo(new BigDecimal("1000")) <= 0) {
            return new BigDecimal("2.50");
        }

        if (amount.compareTo(new BigDecimal("10000")) <= 0) {
            return new BigDecimal("5.00");
        }

        return new BigDecimal("10.00");
    }
}
