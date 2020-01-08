package com.xrltao.mapper;

import com.xrltao.po.Video;
import com.xrltao.provider.VideoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/4 23:48
 * @Description 视频管理数据层
 */
@Mapper
public interface VideoMapper {
    @Select("SELECT * FROM video")
    List<Video> selectAll();

    @Select("SELECT * FROM video WHERE id = #{id}")
    Video findById(int id);

    @UpdateProvider(type = VideoProvider.class, method = "updateVideo")
    int update(Video Video);

    @Delete("DELETE FROM video WHERE id =#{id}")
    int delete(int id);

    @Insert("INSERT INTO `video` (" +
            "`title`, `summary`,`cover_img`, `view_num`, " +
            "`price`, `create_time`,`online`, `point`" +
            ") VALUES (" +
            "#{title},#{summary},#{coverImg},#{viewNum}," +
            "#{price},#{createTime},#{online},#{point}" +
            ")")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id") //返回自增的id
    int save(Video video);
}
