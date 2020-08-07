package cn.tedu.sp04.order.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemFeignClientFB implements ItemFeignClient
{
    @Override
    public JsonResult<List<Item>> getItems(String OrderId) {
        if (Math.random()<0.5){
            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item(1,"缓存商品1",3));
            items.add(new Item(2,"缓存商品2",2));
            items.add(new Item(3,"缓存商品3",4));
            items.add(new Item(4,"缓存商品4",6));
            items.add(new Item(5,"缓存商品5",2));

            return  JsonResult.ok().data(items);
        }
        return JsonResult.err().msg("获取商品列表失败！！1");
    }

    @Override
    public JsonResult<?> decreaseNumber(List<Item> items) {


        return JsonResult.err().msg("减少商品库存失败！！！！");


    }
}
