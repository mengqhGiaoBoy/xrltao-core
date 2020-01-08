package com;

import com.xrltao.po.User;
import com.xrltao.po.Video;
import com.xrltao.provider.VideoProvider;
import com.xrltao.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/5 18:33
 * @Description
 */
public class JDKTest {
    public static void main(String[] args) {
        Claims claims = JwtUtils.parserToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4cmx0YW8iLCJpZCI6MTIyMjIyLCJuYW1lIjoiYWFhYWFhYWEiLCJoZWFkSW1nIjoiYWFhYWFhYSIsImlhdCI6MTU3ODMxOTg4MSwiZXhwIjoxNTc4NDA2MjgxfQ.DPtHo-OcrKdO4lgMDqqRNw8KNW8IU5bpq-CzdjyS0Jw");
        System.out.println(claims.get("namxzdfe"));

    }
}
