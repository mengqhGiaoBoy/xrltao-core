package com.xrltao.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xrltao.domain.ResultDTO;
import com.xrltao.dto.VideoOrderDto;
import com.xrltao.service.interfaces.VideoOrderService;
import com.xrltao.util.IpUtils;
import com.xrltao.util.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
    public void saveVideoOrder(@RequestParam(value = "video_id",required = true) int id,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取用户ip
        String userIp = "127.0.0.1";
        // todo 获取用户id
        int userId = 1 ;
        VideoOrderDto videoOrderDto = new VideoOrderDto();
        videoOrderDto.setIp(userIp);
        videoOrderDto.setUserId(userId);
        videoOrderDto.setVideoId(id);
        String codeUrl = videoOrderService.save(videoOrderDto);
        if (codeUrl == null) {
            // TODO
            throw new NullPointerException();
        }
        // 生成二维码
        try {
            // 二维码配置map
            Map<EncodeHintType, Object> hints = new HashMap<>();
            // 错误等级
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            // 编码
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(codeUrl,
                    BarcodeFormat.QR_CODE, 400, 400, hints);
            // 将二维码写会客户端
            OutputStream outputStream = response.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);

        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/xr_WXCallBack")
    public void WXCallBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("======================================");
        InputStream inputStream = request.getInputStream();
        BufferedReader bufRead = new BufferedReader(
                new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufRead.readLine()) != null){
            sb.append(line);
        }
        inputStream.close();
        bufRead.close();
        // 获取支付响应后转为map
        try {
            Map<String, String> responsMap = WXPayUtil.xmlToMap(sb.toString());
            System.out.println(responsMap);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
