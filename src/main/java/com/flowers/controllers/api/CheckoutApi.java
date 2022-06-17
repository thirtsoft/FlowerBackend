package com.flowers.controllers.api;

import com.flowers.dtos.checkout.Purchase;
import com.flowers.dtos.checkout.PurchaseResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.flowers.utils.Constants.APP_ROOT;
public interface CheckoutApi {

    /*
    @PostMapping(value = APP_ROOT + "/checkout/placeToOrder",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PurchaseResponse> purchase(@RequestBody Purchase purchase);

    @PostMapping(value = APP_ROOT + "/checkout/placeToOrderWithUser",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PurchaseResponse> purchaseWithUser(@RequestBody Purchase purchase, @RequestParam Long id);
    */


    @PostMapping(value = APP_ROOT + "/checkout/placeToOrderWithLoginUser",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PurchaseResponse> purchaseWithLoginUser(@RequestBody Purchase purchase, @RequestParam  Long id);



}
