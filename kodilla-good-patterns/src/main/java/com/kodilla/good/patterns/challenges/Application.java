package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {

        ProductOrderService productOrderService = new ProductOrderService(
                new MailInformationService(), new SaleServiceImpl(), new SaleRepositoryImpl());

        SaleRequest saleRequest = new SaleRequest(new User("Adam", "as@o2.pl"), LocalDateTime.now());

        SaleDto saleDto = productOrderService.process(saleRequest);
        System.out.println(saleDto);
    }
}
