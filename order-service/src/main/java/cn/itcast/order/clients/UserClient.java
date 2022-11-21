package cn.itcast.order.clients;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userService")
public interface UserClient {
    @GetMapping("/user/{id}")
    User findUserById(@PathVariable("id") Long id);
}
