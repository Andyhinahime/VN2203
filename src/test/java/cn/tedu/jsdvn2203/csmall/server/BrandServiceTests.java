package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BrandServiceTests {
    @Autowired
    IBrandService brandService;
    @Test
    public void deleteById(){
        Long id = 12L;
        try {
            brandService.deleteById(id);
            log.debug("刪除成功,影響ID:{}",id);
        } catch (ServiceException e) {
            log.debug("刪除失敗,狀態碼:{}",e.getServiceCode());
            log.debug("刪除失敗原因{}",e.getMessage());
        }
    }

}
