package com.example.sp02.item.controller;

import com.example.sp01.pojo.Item;
import com.example.sp01.service.ItemService;
import com.example.sp01.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    //为了测试，观察哪一台服务器执行
    //拿yml配置
    @Value("${server.port}")
    private int port;

    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) throws InterruptedException {
        log.info("server.port="+port+", orderId="+orderId);

        //设置随即超时
        if (Math.random()<0.6){
            long t = new Random().nextInt(5000);
            log.info("item-service-"+port+"-暂停-"+t);
            Thread.sleep(t);
        }
        //

        List<Item> items = itemService.getItems(orderId);
        return JsonResult.ok(items).msg("port="+port);
    }

    @PostMapping("/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        itemService.decreaseNumbers(items);
        return JsonResult.ok();
    }
}