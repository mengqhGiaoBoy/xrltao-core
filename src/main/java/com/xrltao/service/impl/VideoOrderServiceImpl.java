package com.xrltao.service.impl;

import com.xrltao.config.WeChatConfig;
import com.xrltao.dto.VideoOrderDto;
import com.xrltao.mapper.UserMapper;
import com.xrltao.mapper.VideoMapper;
import com.xrltao.mapper.VideoOrderMapper;
import com.xrltao.po.User;
import com.xrltao.po.Video;
import com.xrltao.po.VideoOrder;
import com.xrltao.service.interfaces.VideoOrderService;

import com.xrltao.util.CommonUtils;
import com.xrltao.util.HttpClientUtil;
import com.xrltao.util.sdk.WXPayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Service("VideoOrderServiceImpl")
public class VideoOrderServiceImpl implements VideoOrderService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Logger dataLogger = LoggerFactory.getLogger("dataLogger");

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String save(VideoOrderDto videoOrderDto) throws Exception {

        dataLogger.info("module=video_order`api=save`user_id={}`video_id={}",videoOrderDto.getUserId(),videoOrderDto.getVideoId());

        //查找视频信息
        Video video =  videoMapper.findById(videoOrderDto.getVideoId());

        //查找用户信息
        User user = userMapper.findByid(videoOrderDto.getUserId());

        //生成订单
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setTotalFee(video.getPrice());
        videoOrder.setVideoImg(video.getCoverImg());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        videoOrder.setVideoId(video.getId());
        videoOrder.setState(0);
        videoOrder.setUserId(1315153);
        videoOrder.setHeadImg("55555");
        videoOrder.setNickname("55555");

        videoOrder.setDel(0);
        videoOrder.setIp(videoOrderDto.getIp());
        videoOrder.setOutTradeNo(CommonUtils.weChatGenerateUUID());

        videoOrderMapper.insert(videoOrder);


        //获取codeurl
        String codeUrl = unifiedOrder(videoOrder);

        return codeUrl;
    }

    @Override
    public VideoOrder findByOutTradeNo(String outTradeNo) {

        return videoOrderMapper.findByOutTradeNo(outTradeNo);
    }

    @Override
    public int updateVideoOderByOutTradeNo(VideoOrder videoOrder) {

        return videoOrderMapper.updateVideoOderByOutTradeNo(videoOrder);
    }


    /**
     * 统一下单方法
     * @return
     */
    private String unifiedOrder(VideoOrder videoOrder) throws Exception {

        //int i = 1/0;   //模拟异常
        //生成签名
        SortedMap<String,String> params = new TreeMap<>();
        params.put("appid",weChatConfig.getAppId());
        params.put("mch_id", weChatConfig.getMchId());
        params.put("nonce_str",CommonUtils.weChatGenerateUUID());
        params.put("body","1");
        params.put("out_trade_no","1");
        params.put("total_fee","501");
        params.put("spbill_create_ip",videoOrder.getIp());
        params.put("notify_url",weChatConfig.getPayCallbackUrl());
        params.put("trade_type","NATIVE");
        String xml = WXPayUtil.generateSignedXml(params, weChatConfig.getKey());

        System.out.println(xml);
        //统一下单
        String orderStr = HttpClientUtil.doPost(WeChatConfig.getUnifiedOrderUrl(),xml,4000);
        if(null == orderStr) {
            return null;
        }
        System.out.println(orderStr.toString());

        return null;
    }






}
