package cn.bw.mall.controller;

import cn.bw.mall.service.IAdItemsService;
import cn.bw.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adItems")
public class AdItemsController {

    @Autowired
    private IAdItemsService adItemsService;

    /**
     * 根据推广产品分类ID查询Sku列表
     */
    @PostMapping("typeSkuItems/{id}")
    public RespResult typeSkuItems(@PathVariable String id ){
        return RespResult.ok(adItemsService.typeSkuItems(id));
    }
    /**
     * 删除缓存
     */
    @DeleteMapping("delskuItems/{id}")
    public RespResult delskuItems(@PathVariable String id){
        adItemsService.delskuItems(id);
        return RespResult.ok();
    }
}
