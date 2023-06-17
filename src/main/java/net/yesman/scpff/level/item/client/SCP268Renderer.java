package net.yesman.scpff.level.item.client;

import net.yesman.scpff.level.item.scps.SCP268ArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SCP268Renderer extends GeoArmorRenderer<SCP268ArmorItem> {
    public SCP268Renderer() {
        super(new SCP268Model());
    }
}
