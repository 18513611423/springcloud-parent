package cn.bw.mall.service.impl;

import cn.bw.mall.mapper.AdItemsMapper;
import cn.bw.mall.mapper.SkuMapper;
import cn.bw.mall.model.AdItems;
import cn.bw.mall.model.Sku;
import cn.bw.mall.service.IAdItemsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdItemsServiceImpl extends ServiceImpl<AdItemsMapper, AdItems> implements IAdItemsService {

    @Autowired
    private AdItemsMapper adItemsMapper;

    @Autowired
    private SkuMapper SkuMapper;
    /**
     *  根据用户分类id 查询sku列表
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "ad-items-skus",key="#id")
    @Override
    public List<Sku> typeSkuItems(String id) {
        QueryWrapper<AdItems> adItemsQueryWrapper=new QueryWrapper<AdItems>();
        adItemsQueryWrapper.eq("type",id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);
        List<String> skuIds = null;
        if(adItems!=null&&adItems.size()>0){
            skuIds = adItems.stream().map(adItem -> adItem.getSkuId()).collect(Collectors.toList());
        }
        List<Sku> skus = null;
        if(skuIds!=null&&skuIds.size()>0){
             skus = SkuMapper.selectBatchIds(skuIds);
        }
        return skus;
    }
    @CacheEvict(cacheNames = "ad-items-skus",key="#id")
    @Override
    public void delskuItems(String id) {

    }
}
