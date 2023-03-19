package cn.tedu.jsdvn2203.csmall.server.schedule;

import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 計畫任務
 */

@Slf4j
@Component
public class CacheSchedule {
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private IBrandRepository brandRepository;

    //cron = "秒 分 時 日 月 周 "
    //@Scheduled(cron = "56 23 18 ? * MON") 表示每個月的周一(無視幾號)的 18:23:56 執行此任務
    @Scheduled(fixedRate = 1 * 60 * 60 * 1000)
    public void updateCache() {
        log.debug("執行計畫任務,更新緩存中的品牌列表...");
        brandRepository.deleteList();

        //從MySql讀取品牌列表
        List<BrandListItemVO> brands = brandMapper.list();
        //將品牌列表寫入到redis
        brandRepository.putList(brands);

    }


}
