package net.yesman.scpff.data;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.yesman.scpff.events.CommonEvents;
import net.yesman.scpff.networking.ModMessages;
import net.yesman.scpff.networking.packet.S2C.Update2521InfoS2CPacket;

public class PlayerData {

    public ServerPlayer player;

    private boolean in2521Event = false;

    public boolean in2521Event() {
        return in2521Event;
    }

    public void updateIn2521Event(boolean in2521Event) {
        this.in2521Event = in2521Event;
        ModMessages.sendToPlayer(new Update2521InfoS2CPacket(in2521Event), this.player);
        this.updateData();
    }

    public static PlayerData getData(Player player) {
        return CommonEvents.PlayerRuntimeData.getOrDefault(player, new PlayerData());
    }

    public void updateData() {
        CommonEvents.PlayerRuntimeData.put(this.player, this);
    }

}
