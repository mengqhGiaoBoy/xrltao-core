package com.xrltao.service.interfaces;

import com.xrltao.po.Video;

import java.util.List;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/5 12:46
 * @Description 视频管理业务层
 */
public interface VideoService {

    List<Video> selectAll();
    int update(Video video);
    int delete(int id);
    int save(Video video);
    Video findById(int id);
}
