package cn.itcast.order.service;

import cn.itcast.order.clients.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        Order order = orderMapper.findById(orderId);
//        String url = "http://userService/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        order.setUser(user);
//        return order;
//    }

    @Autowired
    UserClient userClient;

    public Order queryOrderById(Long orderId) {
        Order order = orderMapper.findById(orderId);

//        String url = "http://userService/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);

        User user = userClient.findUserById(order.getUserId());
        order.setUser(user);
        return order;
    }


}
