package cn.bw.mall.service;

import cn.bw.mall.model.AdItems;
import cn.bw.mall.model.Sku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IAdItemsService extends IService<AdItems> {
    List<Sku>  typeSkuItems(String id);

    void delskuItems(String id);
}
