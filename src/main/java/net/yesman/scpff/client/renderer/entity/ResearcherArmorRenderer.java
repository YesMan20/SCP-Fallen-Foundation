package net.yesman.scpff.client.renderer.entity;


import net.yesman.scpff.client.model.armor.ResearcherArmorModel;
import net.yesman.scpff.level.item.custom.ResearcherArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ResearcherArmorRenderer extends GeoArmorRenderer<ResearcherArmorItem> {
    public ResearcherArmorRenderer() {
        super(new ResearcherArmorModel());
    }
}
