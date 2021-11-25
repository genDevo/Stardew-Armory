package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.conatiners.GalaxyForgeContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, StardewArmory.MOD_ID);

    public static final RegistryObject<ContainerType<GalaxyForgeContainer>> GALAXY_FORGE_CONTAINER
            = CONTAINERS.register("galaxy_forge_container",
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.level;
                return new GalaxyForgeContainer(windowId, world, pos, inv, inv.player);
            }));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
