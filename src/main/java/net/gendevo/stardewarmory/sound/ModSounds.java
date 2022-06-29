package net.gendevo.stardewarmory.sound;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    public static SoundEvent LUCKY_HIT_SOUND = registerSoundEvent("lucky_hit_sound");
    public static SoundEvent YOBA_SOUND = registerSoundEvent("yoba_sound");
    public static SoundEvent TOGGLE_ON_SOUND = registerSoundEvent("toggle_on_sound");
    public static SoundEvent TOGGLE_OFF_SOUND = registerSoundEvent("toggle_off_sound");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(StardewArmory.MODID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void register() {}
}
