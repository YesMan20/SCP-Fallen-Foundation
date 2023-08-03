package net.yesman.scpff.level.item.client;

import net.yesman.scpff.level.item.scps.SCP035ArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SCP035Renderer extends GeoArmorRenderer<SCP035ArmorItem> {
    public SCP035Renderer() {
        super(new SCP035Model());
    }
}
