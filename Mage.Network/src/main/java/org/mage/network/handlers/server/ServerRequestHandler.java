package org.mage.network.handlers.server;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mage.remote.DisconnectReason;
import org.mage.network.interfaces.MageServer;
import org.mage.network.messages.requests.ServerRequest;

/**
 *
 * @author BetaSteward
 */
@Sharable
public class ServerRequestHandler extends SimpleChannelInboundHandler<ServerRequest> {
            
    private final MageServer server;
    
    public ServerRequestHandler(MageServer server) {
        this.server = server;
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, ServerRequest msg) {
        msg.handleMessage(server, ctx);
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        server.disconnect(getSessionId(ctx), DisconnectReason.Disconnected);
    }
    
    private String getSessionId(ChannelHandlerContext ctx) {
        return ctx.channel().id().asLongText();
    }
    
}