package net.yesman.scpff.server.item.client;

import net.yesman.scpff.server.item.custom.DClassArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DClassArmorRenderer extends GeoArmorRenderer<DClassArmorItem> {
    public DClassArmorRenderer() {
        super(new DClassArmorModel());
    }
}
