package org.mage.network.messages.requests;

import io.netty.channel.ChannelHandlerContext;
import org.mage.network.handlers.WriteListener;
import org.mage.network.interfaces.MageServer;
import org.mage.network.messages.responses.ServerMessagesMessage;

/**
 *
 * @author BetaSteward
 */
public class ServerMessagesRequest extends ServerRequest {

    @Override
    public void handleMessage(MageServer server, ChannelHandlerContext ctx) {
        ctx.writeAndFlush(new ServerMessagesMessage(server.getServerMessages())).addListener(WriteListener.getInstance());
    }
    
    
}