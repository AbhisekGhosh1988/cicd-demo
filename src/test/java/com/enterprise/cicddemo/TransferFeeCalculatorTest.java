package com.enterprise.cicddemo;



import com.enterprise.cicddemo.service.TransferFeeCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransferFeeCalculatorTest {

    private final TransferFeeCalculator calculator =
            new TransferFeeCalculator();

    @Test
    void shouldCalculateFeeForSmallTransfer() {

        BigDecimal fee = calculator.calculateFee(
                new BigDecimal("500")
        );

        assertEquals(0, new BigDecimal("2.50").compareTo(fee));
    }
    @Test
    void shouldCalculateFeeAtFirstBoundary() {

        BigDecimal fee = calculator.calculateFee(
                new BigDecimal("1000")
        );

        assertEquals(0, new BigDecimal("2.50").compareTo(fee));
    }

    @Test
    void shouldCalculateFeeForMediumTransfer() {

        BigDecimal fee = calculator.calculateFee(
                new BigDecimal("5000")
        );

        assertEquals(0, new BigDecimal("5.00").compareTo(fee));
    }

    @Test
    void shouldCalculateFeeAtSecondBoundary() {

        BigDecimal fee = calculator.calculateFee(
                new BigDecimal("10000")
        );

        assertEquals(0, new BigDecimal("5.00").compareTo(fee));
    }

    @Test
    void shouldCalculateFeeForLargeTransfer() {

        BigDecimal fee = calculator.calculateFee(
                new BigDecimal("15000")
        );

        assertEquals(0, new BigDecimal("10.00").compareTo(fee));
    }

    @Test
    void shouldRejectZeroTransfer() {

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateFee(BigDecimal.ZERO)
        );
    }

    @Test
    void shouldRejectNegativeTransfer() {

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateFee(new BigDecimal("-100"))
        );
    }

    @Test
    void shouldRejectNullTransfer() {

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateFee(null)
        );
    }
}
