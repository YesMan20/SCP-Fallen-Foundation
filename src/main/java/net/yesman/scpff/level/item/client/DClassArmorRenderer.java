package net.yesman.scpff.level.item.client;

import net.yesman.scpff.level.item.custom.DClassArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DClassArmorRenderer extends GeoArmorRenderer<DClassArmorItem> {
    public DClassArmorRenderer() {
        super(new DClassArmorModel());
    }
}
