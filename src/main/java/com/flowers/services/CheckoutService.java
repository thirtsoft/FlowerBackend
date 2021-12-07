package com.flowers.services;

import com.flowers.models.checkout.Purchase;
import com.flowers.models.checkout.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeToOrder(Purchase purchase);

    PurchaseResponse placeToOrderWithUser(Purchase purchase);
}
