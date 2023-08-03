package net.yesman.scpff.level.item.client;

import net.yesman.scpff.level.item.custom.NtfArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NtfArmorRenderer extends GeoArmorRenderer<NtfArmorItem> {
    public NtfArmorRenderer() {
        super(new NtfArmorModel());
    }
}
