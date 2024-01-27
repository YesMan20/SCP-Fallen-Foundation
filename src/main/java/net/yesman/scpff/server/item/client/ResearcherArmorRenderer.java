package net.yesman.scpff.server.item.client;


import net.yesman.scpff.server.item.custom.ResearcherArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ResearcherArmorRenderer extends GeoArmorRenderer<ResearcherArmorItem> {
    public ResearcherArmorRenderer() {
        super(new ResearcherArmorModel());
    }
}
