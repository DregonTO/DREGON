package com.example.sp09.service;


import java.util.List;

import com.example.sp01.pojo.Item;
import com.example.sp01.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class ItemFeignServiceFB implements ItemFeignService {

    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存");
    }

}

