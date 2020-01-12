package com.xrltao.controller;

import com.xrltao.domain.ResultDTO;
import com.xrltao.dto.VideoOrderDto;
import com.xrltao.service.interfaces.VideoOrderService;
import com.xrltao.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/** 视频订单
 * @author mengqh
 * @version 1.0
 * @date 2020/1/12 16:49
 * @Description
 */
@RestController
@RequestMapping("/video_order")
public class VideoOrderController {

    @Resource(name = "VideoOrderServiceImpl")
    private VideoOrderService videoOrderService;

    @RequestMapping("/xr_saveVideoOrder")
    public ResultDTO saveVideoOrder(@RequestParam(value = "video_id",required = true) int id,
                                    HttpServletRequest request) throws Exception {
        // 获取用户ip
        String userIp = "127.0.0.1";
        // todo 获取用户id
        int userId = 1 ;
        VideoOrderDto videoOrderDto = new VideoOrderDto();
        videoOrderDto.setIp(userIp);
        videoOrderDto.setUserId(userId);
        videoOrderDto.setVideoId(id);
        videoOrderService.save(videoOrderDto);
        return null;
    }
}
