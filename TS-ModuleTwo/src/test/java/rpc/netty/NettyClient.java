package rpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpc.entity.RpcRequest;
import rpc.entity.RpcResponse;
import rpc.kryo.NettyKryoDecoder;
import rpc.kryo.NettyKryoEncoder;

/***
 * @Author trojan
 * @Date 2022/6/9 10:58
 * @Description
 * @Version 1.0
 */

public class NettyClient {
    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);
    private static String host;
    private static int port;
    private static Bootstrap b;

    public NettyClient() {
        super();
    }

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    static {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        b = new Bootstrap();
        b.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                // backlog 指定了内核为此套接口排队的最大连接个数；
                // 对于给定的监听套接口，内核要维护两个队列: 未连接队列和已连接队列
                // backlog 的值即为未连接队列和已连接队列的和。
                .option(ChannelOption.SO_BACKLOG, 128)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)//设置超时时间，超时重发
                .handler(new LoggingHandler(LogLevel.INFO))
                .handler(new ChannelInitializer<SocketChannel>() {//初始化时调用
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new NettyKryoDecoder());//添加解码处理类
                        ch.pipeline().addLast(new NettyKryoEncoder());//加密处理类
                        ch.pipeline().addLast(new NettyClientHandler());//业务处理
                    }
                });
    }


    public RpcResponse sendMessage(RpcRequest rpcRequest) throws InterruptedException {
        try {
            ChannelFuture cf = b.connect().sync();
            logger.info("client connect to {}:{}", host, port);
            Channel channel = cf.channel();
            logger.info("send message");
            if (channel != null) {
                channel.writeAndFlush(rpcRequest).addListener(future -> {
                    if (future.isSuccess()) {
                        logger.info("message send success,[{}]", rpcRequest.toString());
                    } else {
                        logger.error("messae send failed:", future.cause());
                    }
                });
                //阻塞等待，直到channel关闭
                channel.closeFuture().sync();
                AttributeKey<RpcResponse> key = AttributeKey.valueOf("rpcResponse");
                return channel.attr(key).get();
            }
        } catch (Exception e) {
            logger.error("message send failed", e);
        }
        return null;
    }
}
