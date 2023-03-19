package cn.tedu.jsdvn2203.csmall.server.preload;

import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 緩存預熱組件類
 */
@Slf4j
//@Component  有計畫任務 故無需再次預熱 計畫任務就會定時觸發更新
public class CachePreLoad implements ApplicationRunner {
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private IBrandRepository brandRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("執行CachePreLoad.run()方法");

        //先將Redis中的品牌列表清除
        brandRepository.deleteList();

        //從MySql讀取品牌列表
        List<BrandListItemVO> brands = brandMapper.list();
        //將品牌列表寫入到redis
        brandRepository.putList(brands);

    }
}
