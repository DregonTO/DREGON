package com.example.sp09.controller;

import java.util.List;

import com.example.sp01.pojo.Item;
import com.example.sp01.pojo.Order;
import com.example.sp01.pojo.User;
import com.example.sp01.util.JsonResult;
import com.example.sp09.service.ItemFeignService;
import com.example.sp09.service.OrderFeignService;
import com.example.sp09.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private ItemFeignService itemService;
    @Autowired
    private UserFeignService userService;
    @Autowired
    private OrderFeignService orderService;

    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        return itemService.getItems(orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        return itemService.decreaseNumber(items);
    }

    /////////////////////////////////////////

    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(@PathVariable Integer userId, Integer score) {
        return userService.addScore(userId, score);
    }

    /////////////////////////////////////////

    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        return orderService.addOrder();
    }
}
