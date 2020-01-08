package com.xrltao.echo;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;

/**
 * @author mengqh
 * @date 2019/12/30 21:41
 * @Description
 * @version 1.0
 */

public class EchoHandler extends ChannelInboundHandlerAdapter {

    /* 读取深入到的消息
     * @author mengqh
     * @date 2019/12/30 21:44
     * @param [ctx, msg]
     * @return void
     * @description
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("客户端传来的信息 ：" + buf.toString());
    }

    /* 读取完毕之后的方法
     * @author mengqh
     * @date 2019/12/30 21:44
     * @param [ctx]
     * @return void
     * @description
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("读取完成....");
    }

    /* 异常处理方法
     * @author mengqh
     * @date 2019/12/30 21:45
     * @param [ctx, cause]
     * @return void
     * @description
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
