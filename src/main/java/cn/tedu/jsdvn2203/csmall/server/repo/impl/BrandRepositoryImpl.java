package cn.tedu.jsdvn2203.csmall.server.repo.impl;

import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
//@Scope("prototype") // 非單例性: 使每次創建時都不同對象
//@Scope("singleton")  默認單例性: 創建時對象唯一性
public class BrandRepositoryImpl implements IBrandRepository {
    public BrandRepositoryImpl() {
        System.out.println("創建資料訪問對象.BrandRepositoryImpl");
    }

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void put(BrandDetailVO brandDetailVO) {
        String key = kEY_PREFIX_BRAND_ITEM + brandDetailVO.getId();
        redisTemplate.opsForValue().set(key, brandDetailVO);

    }

    @Override
    public BrandDetailVO get(Long id) {
        String key = kEY_PREFIX_BRAND_ITEM + id;
        BrandDetailVO brandDetailVO = null;
        Serializable serializable
                = redisTemplate.opsForValue().get(key);
        if (serializable != null) {
            if (serializable instanceof BrandDetailVO) {
                brandDetailVO = (BrandDetailVO) serializable;
            }
        }
        return brandDetailVO;
    }

    @Override
    public void putList(List<BrandListItemVO> list) {
        log.debug("向redis中寫入品牌列表資料...:{}",list);
        for (BrandListItemVO brand : list) {
            redisTemplate.opsForList().rightPush(KEY_BRAND_LIST,brand);
        }
        log.debug("寫入完畢");
    }

    @Override
    public List<BrandListItemVO> getList() {
        log.debug("從redis讀取品牌列表資料...");
        List<BrandListItemVO> brands= new ArrayList<>();

        List<Serializable> serializable
                = redisTemplate.opsForList().range(KEY_BRAND_LIST, 0, -1);

        for (Serializable brand : serializable) {
            if (brand != null){
                if (brand instanceof BrandListItemVO){
                    brands.add((BrandListItemVO) brand);
                }
            }
        }
        log.debug("讀取完畢");
        //直接返回緩存中的品牌資料
        return brands;
    }

    @Override
    public void deleteItem(Long id) {
        redisTemplate.delete(kEY_PREFIX_BRAND_ITEM+id);
    }

    @Override
    public void deleteList() {
        redisTemplate.delete(KEY_BRAND_LIST);
    }
}
