package pl.januszkiewicz.sales.offering;

import org.junit.jupiter.api.Test;
import pl.januszkiewicz.ecommerce.sales.offering.Offer;
import pl.januszkiewicz.ecommerce.sales.offering.OfferCalculator;

import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class OfferCalculatorTest {
    @Test
    void zeroOfferForEmptyItems() {
        OfferCalculator calculator = new OfferCalculator();

        Offer offer = calculator.calculate(Collections.emptyList());

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
    }
}
