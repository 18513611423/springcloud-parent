package cn.bw.mall.mapper;

import cn.bw.mall.model.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface SkuSearchMapper extends ElasticsearchCrudRepository<SkuEs,String>{

}
