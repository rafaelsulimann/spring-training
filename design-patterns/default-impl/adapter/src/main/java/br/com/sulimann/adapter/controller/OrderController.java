package br.com.sulimann.adapter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulimann.adapter.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public String placeOrder(
            @RequestParam String orderId,
            @RequestParam double amount,
            @RequestParam String currency,
            @RequestParam String accountId) {

        boolean success = orderService.placeOrder(orderId, amount, currency, accountId);

        if (success) {
            return "Pedido processado com sucesso!";
        } else {
            return "Falha ao processar o pedido.";
        }
    }
}
