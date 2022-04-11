package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.screen.GalaxyForgeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static DeferredRegister<MenuType<?>> MENUS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, StardewArmory.MOD_ID);

    public static final RegistryObject<MenuType<GalaxyForgeMenu>> GALAXY_FORGE_CONTAINER
            = registerMenuType(GalaxyForgeMenu::new, "galaxy_forge_menu");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
