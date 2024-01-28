package net.yesman.scpff.client.renderer.entity;

import net.yesman.scpff.client.model.armor.NtfArmorModel;
import net.yesman.scpff.server.item.custom.NtfArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NtfArmorRenderer extends GeoArmorRenderer<NtfArmorItem> {
    public NtfArmorRenderer() {
        super(new NtfArmorModel());
    }
}
