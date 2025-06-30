package pl.januszkiewicz.ecommerce.sales;

import pl.januszkiewicz.ecommerce.sales.cart.Cart;
import pl.januszkiewicz.ecommerce.sales.cart.HashMapCartStorage;
import pl.januszkiewicz.ecommerce.sales.offering.Offer;
import pl.januszkiewicz.ecommerce.sales.offering.OfferCalculator;
import pl.januszkiewicz.ecommerce.sales.payment.PaymentDetails;
import pl.januszkiewicz.ecommerce.sales.payment.PaymentGateway;
import pl.januszkiewicz.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.januszkiewicz.ecommerce.sales.reservation.AcceptOfferRequest;
import pl.januszkiewicz.ecommerce.sales.reservation.Reservation;
import pl.januszkiewicz.ecommerce.sales.reservation.ReservationDetails;
import pl.januszkiewicz.ecommerce.sales.reservation.ReservationRepository;

import java.util.UUID;

public class SalesFacade {
    private HashMapCartStorage cartStorage;
    private OfferCalculator offerCalculator;
    private PaymentGateway paymentGateway;
    private ReservationRepository reservationRepository;

    public SalesFacade(HashMapCartStorage cartStorage, OfferCalculator offerCalculator, PaymentGateway paymentGateway, ReservationRepository reservationRespository) {
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
        this.paymentGateway = paymentGateway;
        this.reservationRepository = reservationRespository;
    }

    public Offer getCurrentOffer(String customerId) {
        return new Offer();
    }

    public void addProduct(String customerId, String productId) {
        Cart cart = getCartForCustomer(customerId);

        cart.add(productId);

    }

    private Cart getCartForCustomer(String customerId) {
        return cartStorage.getForCustomer(customerId)
                .orElse(Cart.empty());
    }

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        String reservationId = UUID.randomUUID().toString();
        Offer offer = this.getCurrentOffer(customerId);

        PaymentDetails paymentDetails = paymentGateway.registerPayment(
                RegisterPaymentRequest.of(reservationId, acceptOfferRequest, offer.getTotal())
        );

        Reservation reservation = Reservation.of(
                reservationId,
                customerId,
                acceptOfferRequest,
                offer,
                paymentDetails);

        reservationRepository.add(reservation);

        return new ReservationDetails(reservationId, paymentDetails.getPaymentUrl());
    }
}
