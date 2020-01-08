package com.xrltao.controller;

import com.xrltao.config.WeChatConfig;
import com.xrltao.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/7 22:11
 * @Description
 */
@RestController()
@RequestMapping("/api/weChat")
public class WeChatController {

    @Autowired
    private WeChatConfig weChatConfig;

    @GetMapping("/login")
    public JsonData login(@RequestParam(value = "access_page", required = true)String access_page) throws UnsupportedEncodingException {
        //获取重定向url
        String redirecUrl = weChatConfig.getOpenRedirectUrl();
        //编码
        String callBack = URLEncoder.encode(redirecUrl,"GBK");
        //格式化二维码图片路径
        String qrcode = String.format(
                WeChatConfig.getOpenQrcodeUrl(),
                weChatConfig.getOpenAppid(),
                callBack,access_page
        );
        return JsonData.buildSuccess(qrcode);
    }
}
