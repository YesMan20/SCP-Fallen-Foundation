package net.yesman.scpff.client.renderer.entity;


import net.yesman.scpff.client.model.armor.GuardArmorModel;
import net.yesman.scpff.server.item.custom.GuardArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GuardArmorRenderer extends GeoArmorRenderer<GuardArmorItem> {
    public GuardArmorRenderer() {
        super(new GuardArmorModel());
    }
}
