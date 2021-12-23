package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, StardewArmory.MOD_ID);

    public static final RegistryObject<SoundEvent> LUCKY_HIT_SOUND =
            registerSoundEvent("lucky_hit_sound");

    public static final RegistryObject<SoundEvent> YOBA_SOUND =
            registerSoundEvent("yoba_sound");

    public static final RegistryObject<SoundEvent> TOGGLE_ON_SOUND =
            registerSoundEvent("toggle_on_sound");

    public static final RegistryObject<SoundEvent> TOGGLE_OFF_SOUND =
            registerSoundEvent("toggle_off_sound");


    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(StardewArmory.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
