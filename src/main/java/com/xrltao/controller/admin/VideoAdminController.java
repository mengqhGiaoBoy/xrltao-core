package com.xrltao.controller.admin;

import com.xrltao.config.XrltaoType;
import com.xrltao.domain.ResultDTO;
import com.xrltao.mapper.VideoMapper;
import com.xrltao.po.Video;
import com.xrltao.service.interfaces.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/5 12:33
 * @Description
 */
@RestController
@RequestMapping("/admin/video")
public class VideoAdminController {

    @Resource(name = "videoImpl")
    private VideoService videoService;

    /*
     * @author mengqh
     * @date 2020/1/5 12:35
     * @param [video]
     * @return void
     * @description 更新视频信息 根据id
     */
    @PostMapping("/xr_update_id")
    public ResultDTO update(@RequestBody Video video){
        ResultDTO result = new ResultDTO();
        int update = videoService.update(video);

        if (update == 0){
            result.setStatus(XrltaoType.RESULT_STATUS_ERROR);
        }else{
            result.setStatus(XrltaoType.RESULT_STATUS_SUCCEED);
        }
        return result;
    }

    /*
     * @author mengqh
     * @date 2020/1/5 13:15
     * @param [video]
     * @return com.xrltao.domain.ResultDTO
     * @description 添加视频数据
     */
    @PostMapping("/xr_saveData")
    public ResultDTO save(@RequestBody Video video){
        ResultDTO result = new ResultDTO();

        List<Video> videos = videoService.selectAll();

        result.setStatus(XrltaoType.RESULT_STATUS_SUCCEED);
        return result;
    }

    /*
     * @author mengqh
     * @date 2020/1/5 18:45
     * @param [video]
     * @return com.xrltao.domain.ResultDTO
     * @description 根据id 删除视频
     */
    public ResultDTO delete(@RequestBody Video video){
        ResultDTO result = new ResultDTO();
        Integer id = video.getId();
        if (id != null){
            id = videoService.delete(id);
            if (id == 0){
                result.setStatus(XrltaoType.RESULT_STATUS_ERROR);
            }else {
                result.setStatus(XrltaoType.RESULT_STATUS_SUCCEED);
            }
            return result;
        }
        result.setStatus(XrltaoType.RESULT_STATUS_ERROR);
        return result;
    }

}
