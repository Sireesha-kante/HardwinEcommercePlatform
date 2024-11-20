package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.service.OrderService;

import lombok.RequiredArgsConstructor;
@RequestMapping("${api.prefix}/orders")
@RestController
public class OrdersController {
	
@Autowired
private OrderService orderService;


}
