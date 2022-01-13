package cn.bw.mall.mallapi.goods;

import cn.bw.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "mall-goods")
public interface SkuFeign {

    /**
     * 根据推广产品分类ID查询Sku列表
     */
    @PostMapping("adItems/typeSkuItems/{id}")
     RespResult typeSkuItems(@PathVariable String id );
    /**
     * 删除缓存
     */
    @DeleteMapping("adItems/delskuItems/{id}")
    RespResult delskuItems(@PathVariable String id);
}
