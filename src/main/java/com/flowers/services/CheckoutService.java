package com.flowers.services;

import com.flowers.dtos.checkout.Purchase;
import com.flowers.dtos.checkout.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeToOrder(Purchase purchase);

    PurchaseResponse placeToOrderWithUser(Purchase purchase);

}
