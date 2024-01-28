package net.yesman.scpff.client.renderer.entity;

import net.yesman.scpff.client.model.armor.DClassArmorModel;
import net.yesman.scpff.server.item.custom.DClassArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DClassArmorRenderer extends GeoArmorRenderer<DClassArmorItem> {
    public DClassArmorRenderer() {
        super(new DClassArmorModel());
    }
}
