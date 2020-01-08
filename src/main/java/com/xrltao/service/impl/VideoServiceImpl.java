package com.xrltao.service.impl;

import com.xrltao.config.XrltaoType;
import com.xrltao.mapper.VideoMapper;
import com.xrltao.po.Video;
import com.xrltao.service.interfaces.VideoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.List;


/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/5 12:46
 * @Description
 */
@Service("videoImpl")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    /*
     * @author mengqh
     * @date 2020/1/5 12:53
     * @param []
     * @return java.util.List<com.xrltao.po.Video>
     * @description 查询所有数据
     */
    @Override
    public List<Video> selectAll() {
        List<Video> videos = videoMapper.selectAll();
        if (videos != null && videos.size() != 0){
            return videos;
        }
        return new ArrayList();
    }

    /*
     * @author mengqh
     * @date 2020/1/5 12:53
     * @param [video]
     * @return int
     * @description 修改视频信息
     */
    @Override
    public int update(Video video) {
        //
        if (video != null && video.getId() != null){
            int status = videoMapper.update(video);
            return status;
        }
        return XrltaoType.RESULT_STATUS_ERROR;
    }

    /*
     * @author mengqh
     * @date 2020/1/5 12:57
     * @param [id]
     * @return int
     * @description 删除视频信息
     */
    @Override
    public int delete(int id) {
        int status = videoMapper.delete(id);
        return status;
    }

    /*
     * @author mengqh
     * @date 2020/1/5 12:57
     * @param [video]
     * @return int
     * @description 保存视频信息
     */
    @Override
    public int save(Video video) {
        if(video != null){
            videoMapper.save(video);
        }
        return XrltaoType.RESULT_STATUS_ERROR;
    }

    /*
     * @author mengqh
     * @date 2020/1/5 13:34
     * @param [id]
     * @return com.xrltao.po.Video
     * @description 通过id查找视频
     */
    @Override
    public Video findById(int id){
        Video video = videoMapper.findById(id);
        if (video != null){
            return video;
        }
        // TODO: 2020/1/5 打印log
        return null;
    }
}
