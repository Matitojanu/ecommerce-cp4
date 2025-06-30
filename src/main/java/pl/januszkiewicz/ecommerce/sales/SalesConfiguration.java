package pl.januszkiewicz.ecommerce.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.januszkiewicz.ecommerce.sales.cart.HashMapCartStorage;
import pl.januszkiewicz.ecommerce.sales.offering.OfferCalculator;
import pl.januszkiewicz.ecommerce.sales.payment.PaymentDetails;
import pl.januszkiewicz.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.januszkiewicz.ecommerce.sales.reservation.ReservationRepository;

@Configuration
public class SalesConfiguration {
    @Bean
    SalesFacade createSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                (RegisterPaymentRequest request) -> {
                    return new PaymentDetails("http://payment");
                },
                new ReservationRepository()
        );
    }
}
