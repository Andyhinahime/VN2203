package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository //
public interface BrandMapper {


    /**
     * 插入品牌數據
     *
     * @param brand
     * @return 受影響的行數, 成功插入數據返回值1
     */
    int insert(Brand brand);

    /**
     * 根據品牌id刪除數據
     *
     * @param id 刪除的品牌數據的id
     * @return 受影響的行數, 刪除成功返回1
     */
    int deleteById(Long id);

    /**
     * 根據若干id一次性刪除多個品牌
     * Long... : 可變長度
     *
     * @param ids 若干個id
     * @return 受影響的行數, 刪除成功時, 返回對應的行數的值
     */
    int deleteByIds(Long... ids);

    /**
     * 根據id修改品牌名稱
     *
     * @param id   品牌id
     * @param name 修改後的新品牌名稱
     * @return 受影響的行數, 修改成功返回1
     * @Param註解來標記對應的參數名稱 JVM底層編譯運行程序時, 默認是不會保存局部變量名稱, 由於方法的參數也是居部變量, 所以參數的名稱
     * 在編譯時就消失了,運行時不能保存,導致Mybatis默認情況下多個參數時,
     * 是不能直接使用參數名稱對應#{}中的內容,但是Springboot對官方創建的java項目JVM參數進行修改,
     * 使得方法的局部變量名稱也能保存,所以直接編寫變量名就可以對應#{}裡面的名稱
     */
    int updateNameById(@Param("id") Long id, @Param("name") String name);

    /**
     * 實現多種不同數據更新(想更新那些舊更新那些,其餘保持不變)
     *
     * @param brand 修改的數據
     * @return 受影響行數, 修改成功返回1
     */
    int updateById(Brand brand);

    /**
     * 統計品牌中的資料數量
     *
     * @return 資料數量
     */
    int count();

    /** 根據品牌名稱統計此品牌名稱數量 */
    int countByName(String name);

    /**
     * 根據id查詢品牌詳情
     * @param id 品牌id
     * @return 品牌詳情
     */
    BrandDetailVO getById(Long id);

    /**
     * 查詢品牌列表
     * @return 品牌列表
     */
    List<BrandListItemVO> list();


}
