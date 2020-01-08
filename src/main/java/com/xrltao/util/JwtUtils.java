package com.xrltao.util;

import com.xrltao.po.User;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/6 21:18
 * @Description
 */
public class JwtUtils {

    //设置面向的用户
    public static final String SUBJECT = "xrltao";
    //过期时间
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    //密钥
    public static final String KEY = "mengqh";

    public static String geneJsonWebToken(User user){
        if(user.getId() == null || user.getName() == null || user.getHeadImg() == null){
            return null;
        }
        //创建 JWT
        JwtBuilder builder = Jwts.builder();
        //设置发行者以及属性
        builder.setSubject(SUBJECT)
               .claim("id", user.getId())
               .claim("name", user.getName())
               .claim("headImg", user.getHeadImg());
        //设置生成时间
        builder.setIssuedAt(new Date());
        //设置过期时间
        builder.setExpiration(new Date(System.currentTimeMillis() + EXPIRE));
        //设置密钥
        builder.signWith(SignatureAlgorithm.HS256,KEY);
        //序列化紧凑
        String token = builder.compact();

        return token;
    }

    public static Claims parserToken(String token){
        //解密失败会发生异常
        try {
            //解析Jwt
            JwtParser parser = Jwts.parser();
            //设置密钥
            parser.setSigningKey(KEY);
            //设置token并获取body(数据体)
            final Claims claims = parser.parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            // TODO: 2020/1/6 打印日志
            return null;
        }
    }
}
