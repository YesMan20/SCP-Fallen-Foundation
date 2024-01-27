package net.yesman.scpff.server.item.client;

import net.yesman.scpff.server.item.custom.NtfArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NtfArmorRenderer extends GeoArmorRenderer<NtfArmorItem> {
    public NtfArmorRenderer() {
        super(new NtfArmorModel());
    }
}
