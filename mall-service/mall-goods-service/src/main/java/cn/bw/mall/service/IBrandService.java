package cn.bw.mall.service;

import cn.bw.mall.model.Brand;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IBrandService extends IService<Brand> {
    List<Brand> queryList(Brand brand);

    Page<Brand> queryPageList(Brand brand, Long currentPage, Long size);
}
