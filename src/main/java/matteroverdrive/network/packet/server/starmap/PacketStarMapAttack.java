package matteroverdrive.network.packet.server.starmap;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.network.packet.PacketAbstract;
import matteroverdrive.network.packet.client.starmap.PacketUpdateTravelEvents;
import matteroverdrive.network.packet.server.AbstractServerPacketHandler;
import matteroverdrive.starmap.GalaxyServer;
import matteroverdrive.api.starmap.GalacticPosition;
import matteroverdrive.starmap.data.Galaxy;
import matteroverdrive.starmap.data.TravelEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Simeon on 6/28/2015.
 */
public class PacketStarMapAttack extends PacketAbstract
{
    GalacticPosition from,to;
    int shipID;

    public PacketStarMapAttack()
    {

    }

    public PacketStarMapAttack(GalacticPosition from,GalacticPosition to,int shipID)
    {
        this.from = from;
        this.to = to;
        this.shipID = shipID;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        from = new GalacticPosition(buf);
        to = new GalacticPosition(buf);
        shipID = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        from.writeToBuffer(buf);
        to.writeToBuffer(buf);
        buf.writeInt(shipID);
    }

    public static class ServerHandler extends AbstractServerPacketHandler<PacketStarMapAttack>
    {
        @Override
        public IMessage handleServerMessage(EntityPlayer player, PacketStarMapAttack message, MessageContext ctx)
        {
            TravelEvent travelEvent = new TravelEvent(player.worldObj,message.from,message.to,message.shipID, GalaxyServer.getInstance().getTheGalaxy());
            if (travelEvent.isValid(GalaxyServer.getInstance().getTheGalaxy()))
            {
                if (GalaxyServer.getInstance().getTheGalaxy().canCompleteTravelEvent(travelEvent))
                {
                    GalaxyServer.getInstance().getTheGalaxy().addTravelEvent(travelEvent);
                    MatterOverdrive.packetPipeline.sendToDimention(new PacketUpdateTravelEvents(GalaxyServer.getInstance().getTheGalaxy()), player.worldObj);
                }
            }
            return null;
        }
    }
}
