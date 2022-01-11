package cn.bw.mall.controller;

import cn.bw.mall.model.Brand;
import cn.bw.mall.service.IBrandService;
import cn.bw.mall.util.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;


      @PostMapping("/queryList")
      public RespResult queryList(@RequestBody(required = false) Brand brand){
         List<Brand> list =  brandService.queryList(brand);
        return  RespResult.ok(list);
      }

    @PostMapping("/queryPageList/{page}/{size}")
    public RespResult<Page<Brand>> queryPageList(@RequestBody(required = false) Brand brand,
            @PathVariable(value = "page")Long currentPage,
             @PathVariable(value = "size")Long size
        ){
        Page<Brand> list =  brandService.queryPageList(brand,currentPage,size);
        return  RespResult.ok(list);
    }
    /***
     * 增加品牌
     */
    @PostMapping
    public RespResult add(@RequestBody Brand brand){
        // 增加品牌
        brandService.save(brand);
        return RespResult.ok();
    }

    /****
     * 修改
     */
    @PutMapping
    public RespResult update(@RequestBody Brand brand){
        //修改品牌
        brandService.updateById(brand);
        return RespResult.ok();
    }

    /****
     * 删除品牌
     */
    @DeleteMapping("/{id}")
    public RespResult delete(@PathVariable(value = "id") Integer id){
        //删除品牌
        brandService.removeById(id);
        return RespResult.ok();
    }
}
