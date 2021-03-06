/*
 * This file is part of Matter Overdrive
 * Copyright (c) 2015., Simeon Radivoev, All rights reserved.
 *
 * Matter Overdrive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Matter Overdrive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Matter Overdrive.  If not, see <http://www.gnu.org/licenses>.
 */

package matteroverdrive.network.packet.client;

import io.netty.buffer.ByteBuf;
import matteroverdrive.network.packet.TileEntityUpdatePacket;
import matteroverdrive.tile.TileEntityMachinePacketQueue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Simeon on 8/22/2015.
 */
public class PacketSendQueueFlash extends TileEntityUpdatePacket {
    public PacketSendQueueFlash() {
        super();
    }

    public PacketSendQueueFlash(TileEntityMachinePacketQueue tileEntity) {
        super(tileEntity);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        super.fromBytes(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        super.toBytes(buf);
    }

    public static class ClientHandler extends AbstractClientPacketHandler<PacketSendQueueFlash> {
        @SideOnly(Side.CLIENT)
        @Override
        public void handleClientMessage(EntityPlayerSP player, PacketSendQueueFlash message, MessageContext ctx) {
            TileEntity tileEntity = message.getTileEntity(player.world);
            if (tileEntity instanceof TileEntityMachinePacketQueue) {
                ((TileEntityMachinePacketQueue) tileEntity).flashTime = 5;
            }
        }
    }
}
