package com.xrltao.provider;

import com.xrltao.po.Video;
import org.apache.ibatis.jdbc.SQL;

import java.util.Set;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/5 18:22
 * @Description Video表的动态sql
 */
public class VideoProvider {

    /*
     * @author mengqh
     * @date 2020/1/5 18:47
     * @param [video]
     * @return java.lang.String
     * @description 更新视频信息
     */
    public String updateVideo(Video video){
        return new SQL(){{
            //设置更新表
            UPDATE("video");
            //图片路径
            if (video.getCoverImg() != null){
                SET("cover_img = #{coverImg}");
            }
            if (video.getCreateTime() != null){
                SET("create_time = #{createTime}");
            }
            if (video.getOnline() != null){
                SET("online = #{online}");
            }
            if (video.getPoint() != null){
                SET("point = #{point}");
            }
            if (video.getPrice() != null){
                SET("price = #{price}");
            }
            if (video.getTitle() != null){
                SET("title = #{title}");
            }
            if (video.getSummary() != null){
                SET("summary = #{summary}");
            }
            if (video.getViewNum() != null){
                SET("view_num = #{viewNum}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }
}
