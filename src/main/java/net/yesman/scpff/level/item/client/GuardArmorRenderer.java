package net.yesman.scpff.level.item.client;


import net.yesman.scpff.level.item.custom.GuardArmorItem;
import net.yesman.scpff.level.item.custom.ResearcherArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GuardArmorRenderer extends GeoArmorRenderer<GuardArmorItem> {
    public GuardArmorRenderer() {
        super(new GuardArmorModel());
    }
}
