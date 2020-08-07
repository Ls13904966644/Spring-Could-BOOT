package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemFeignClientFB implements ItemFeignClient{

    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err("获取商品订单失败");
    }

    @Override
    public JsonResult<?> decreaseNumber(List<Item> items) {
        return JsonResult.err("无法保存订单");
    }
}
