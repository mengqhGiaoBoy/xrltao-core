package com.xrltao.controller;

import ch.qos.logback.core.joran.spi.ElementSelector;
import com.xrltao.config.WeChatConfig;
import com.xrltao.config.XrltaoType;
import com.xrltao.domain.ResultDTO;
import com.xrltao.mapper.VideoMapper;
import com.xrltao.po.Video;
import com.xrltao.service.interfaces.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/4 23:08
 * @Description
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /*
     * @author mengqh
     * @date 2020/1/5 13:10
     * @param [currentPage: 当前页数，size： 每页条数]
     * @return com.xrltao.domain.ResultDTO
     * @description 查询所有数据(分页接口)
     */
    @GetMapping("/xr_findAll")
    public ResultDTO selectAll(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                               @RequestParam(value = "size",defaultValue = "10") int size
                               ){
        ResultDTO result = new ResultDTO();
        List<Video> videos = videoService.selectAll();

        result.setStatus(XrltaoType.RESULT_STATUS_SUCCEED);
        result.setContent(videos);
        return result;
    }
    /*
     * @author mengqh
     * @date 2020/1/5 13:41
     * @param [videoId]
     * @return com.xrltao.domain.ResultDTO
     * @description 根据id找视频
     */
    @GetMapping("/xr_findId")
    public ResultDTO findbyId(@RequestParam(value = "video_id",required = true) int videoId){
        ResultDTO result = new ResultDTO();
        Video video = videoService.findById(videoId);
        if (video != null){
            result.setStatus(XrltaoType.RESULT_STATUS_SUCCEED);
            result.setContent(video);
        }else {
            result.setStatus(XrltaoType.RESULT_STATUS_SUCCEED);
        }
        return result;
    }


}
