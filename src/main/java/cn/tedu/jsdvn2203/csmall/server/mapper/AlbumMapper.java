package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AlbumDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AlbumListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumMapper {
    /** 插入相冊數據 */
    int insert(Album album);

    /** 根據相冊id刪除資料 */
    int deleteById(Long id);

    /** 根據若干個id一次性刪除多個相冊 */
    int deleteByIds(Long... ids);

    /** 根據id修改相冊名稱 */
    int updateNameById(Long id,String name);

    /** 實現多種不同數據更新 */
    int updateById(Album album);

    /** 統計相冊的數量 */
    int count();

    /** 根據名稱統計數量 */
    int countByName(String name);

    /** 根據id查詢詳情 */
    AlbumDetailVO getById(Long id);

    /** 查詢列表 */
    List<AlbumListItemVO> list();

}
