package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.conatiners.GalaxyForgeContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainers {

    public static DeferredRegister<MenuType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, StardewArmory.MOD_ID);

    public static final RegistryObject<MenuType<GalaxyForgeContainer>> GALAXY_FORGE_CONTAINER
            = CONTAINERS.register("galaxy_forge_container",
            () -> IForgeMenuType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                Level world = inv.player.level;
                return new GalaxyForgeContainer(windowId, world, pos, inv, inv.player);
            }));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
