package cn.bw.mall.service.impl;

import cn.bw.mall.mapper.BrandMapper;
import cn.bw.mall.model.Brand;
import cn.bw.mall.service.IBrandService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> queryList(Brand brand) {
        QueryWrapper<Brand> wrapper = new QueryWrapper<Brand>();
        if(StringUtils.isNotBlank(brand.getName())){
            wrapper.like("name",brand.getName());
        }
        return brandMapper.selectList(wrapper);
    }

    @Override
    public Page<Brand> queryPageList(Brand brand, Long currentPage, Long size) {
        QueryWrapper<Brand> wrapper = new QueryWrapper<Brand>();
        if(StringUtils.isNotBlank(brand.getName())){
            wrapper.like("name",brand.getName());
        }
        return brandMapper.selectPage(new Page<Brand>(currentPage,size),wrapper);

    }
}
