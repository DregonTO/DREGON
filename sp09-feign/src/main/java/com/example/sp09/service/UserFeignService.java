package com.example.sp09.service;


import com.example.sp01.pojo.User;
import com.example.sp01.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("user-service")
public interface UserFeignService {
    @GetMapping("/{userId}")
    JsonResult<User> getUser(@PathVariable Integer userId);

    // 拼接路径 /{userId}/score?score=新增积分
    @GetMapping("/{userId}/score")
    JsonResult addScore(@PathVariable Integer userId, @RequestParam Integer score);
}
