package cn.tedu.sp04.order.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.OrderService;
import cn.tedu.sp04.order.feign.ItemFeignClient;
import cn.tedu.sp04.order.feign.UserFeignClient;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceIpml implements OrderService {


    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private ItemFeignClient itemFeignClient;

    @Override
    public Order getOrder(String orderId) {
        // 调用用户，获取用户
        // 真实项目中，要获得已登录的用户id
        JsonResult<User> user = userFeignClient.getUser(7);

        JsonResult<List<Item>> items = itemFeignClient.getItems(orderId);
        log.info("调用用户结果" + user);
        log.info("调用商品结果" + items);

        Order order = new Order();
        order.setId(orderId);
        order.setUser(user.getData());
        order.setItems(items.getData());
        return order;
    }

    @Override
    public void addOrder(Order order) {
        userFeignClient.addScore(order.getUser().getId(),1000);
        itemFeignClient.decreaseNumber(order.getItems());

        log.info("保存订单！" + order);
    }
}
