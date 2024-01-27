package net.yesman.scpff.server.item.client;


import net.yesman.scpff.server.item.custom.GuardArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GuardArmorRenderer extends GeoArmorRenderer<GuardArmorItem> {
    public GuardArmorRenderer() {
        super(new GuardArmorModel());
    }
}
