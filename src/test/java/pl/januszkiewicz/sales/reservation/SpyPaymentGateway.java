package pl.januszkiewicz.sales.reservation;

import pl.januszkiewicz.ecommerce.sales.payment.PaymentDetails;
import pl.januszkiewicz.ecommerce.sales.payment.PaymentGateway;
import pl.januszkiewicz.ecommerce.sales.payment.RegisterPaymentRequest;

public class SpyPaymentGateway implements PaymentGateway {
    Integer requestCount = 0;
    public RegisterPaymentRequest lastRequest;

    public Integer getRequestsCount() {
        return requestCount;
    }

    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        this.requestCount++;
        lastRequest = registerPaymentRequest;
        return new PaymentDetails("http://spy-gateway");
    }
}
