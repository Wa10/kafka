package com.wala.paymentservice.service;

import com.wala.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
