package net.gendevo.stardewarmory.util.events;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.entities.GuildMasterEntity;
import net.gendevo.stardewarmory.setup.ModEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.GUILD_MASTER.get(), GuildMasterEntity.createAttributes().build());
    }
}
