package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class OrderFeignClientFB implements OrderFeignClient{
    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("获取商品列表失败");
    }

    @Override
    public JsonResult<?> addOrder() {
        return JsonResult.err("修改商品库存失败");
    }
}
