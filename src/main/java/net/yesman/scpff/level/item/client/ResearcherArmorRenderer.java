package net.yesman.scpff.level.item.client;


import net.yesman.scpff.level.item.custom.ResearcherArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ResearcherArmorRenderer extends GeoArmorRenderer<ResearcherArmorItem> {
    public ResearcherArmorRenderer() {
        super(new ResearcherArmorModel());
    }
}
