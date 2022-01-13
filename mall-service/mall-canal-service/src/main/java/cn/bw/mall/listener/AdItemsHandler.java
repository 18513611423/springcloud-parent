package cn.bw.mall.listener;

import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

@CanalTable(value = "ad_items")
@Component
public class AdItemsHandler implements EntryHandler<AdItems> {
    @Override
    public void insert(AdItems adItems) {
        System.out.println("111111");
    }





    @Override
    public void update(AdItems before, AdItems after) {
        System.out.println("111111");
    }

    @Override
    public void delete(AdItems adItems) {
        System.out.println("111111");
    }
}

/*
 EntryHandler<Map<String, String>> {
@Override
public void insert(Map<String, String> map) {
        log.info("新增，{}", map);
        }

@Override
public void update(Map<String, String> before, Map<String, String> after) {
        // CanalModel可以得到当前这次的库名和表名
        CanalModel canal = CanalContext.getModel();
        log.info("更新，更新前={}，更新后={}", before, after);
        }

@Override
public void delete(Map<String, String> map) {
        log.info("删除，{}", map);
        }*/
