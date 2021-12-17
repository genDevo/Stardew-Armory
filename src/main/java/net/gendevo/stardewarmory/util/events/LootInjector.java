package net.gendevo.stardewarmory.util.events;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID)
public final class LootInjector {
    public static final class Tables {
        private static final Map<ResourceLocation, ResourceLocation> MAP = new HashMap<>();

        public static final ResourceLocation CHESTS_IGLOO = inject(new ResourceLocation("chests/igloo_chest"));
        public static final ResourceLocation CHESTS_SPAWN = inject(new ResourceLocation("chests/spawn_bonus_chest"));
        public static final ResourceLocation CHESTS_VILLAGE_TEMPLE = inject(new ResourceLocation("chests/village/village_temple"));
        public static final ResourceLocation CHESTS_VILLAGE_WEAPONSMITH = inject(new ResourceLocation("chests/village/village_weaponsmith"));
        public static final ResourceLocation CHESTS_VILLAGE_BUTCHER = inject(new ResourceLocation("chests/village/village_butcher"));
        public static final ResourceLocation CHESTS_VILLAGE_TOOLSMITH = inject(new ResourceLocation("chests/village/village_toolsmith"));
        public static final ResourceLocation CHESTS_NETHER_BRIDGE = inject(new ResourceLocation("chests/nether_bridge"));
        public static final ResourceLocation CHESTS_BASTION_BRIDGE = inject(new ResourceLocation("chests/bastion_bridge"));
        public static final ResourceLocation CHESTS_BASTION_TREASURE = inject(new ResourceLocation("chests/bastion_treasure"));
        public static final ResourceLocation CHESTS_BASTION_OTHER = inject(new ResourceLocation("chests/bastion_other"));
        public static final ResourceLocation CHESTS_SHIP = inject(new ResourceLocation("chests/shipwreck_supply"));
        public static final ResourceLocation CHESTS_PILLAGER = inject(new ResourceLocation("chests/pillager_outpost"));
        public static final ResourceLocation CHESTS_RUINED_PORTAL = inject(new ResourceLocation("chests/ruined_portal"));
        public static final ResourceLocation CHESTS_UNDERWATER_RUINS = inject(new ResourceLocation("chests/underwater_ruin_big"));
        public static final ResourceLocation CHESTS_STRONGHOLD = inject(new ResourceLocation("chests/stronghold_corridor"));
        public static final ResourceLocation CHESTS_MINESHAFT = inject(new ResourceLocation("chests/abandoned_mineshaft"));
        public static final ResourceLocation CHESTS_SIMPLE_DUNGEON = inject(new ResourceLocation("chests/simple_dungeon"));
        public static final ResourceLocation CHESTS_DESERT_PYRAMID = inject(new ResourceLocation("chests/desert_pyramid"));
        public static final ResourceLocation CHESTS_JUNGLE_TEMPLE = inject(new ResourceLocation("chests/jungle_temple"));
        public static final ResourceLocation CHESTS_WOODLAND_MANSION = inject(new ResourceLocation("chests/woodland_mansion"));
        public static final ResourceLocation CHESTS_BURIED_TREASURE = inject(new ResourceLocation("chests/buried_treasure"));


        public static final ResourceLocation PIGLIN_BARTER = inject(new ResourceLocation("gameplay/piglin_bartering"));

        public static final ResourceLocation FISHING_TREASURE = inject(new ResourceLocation("gameplay/fishing/treasure"));
        public static final ResourceLocation FISHING_JUNK = inject(new ResourceLocation("gameplay/fishing/junk"));

        public static final ResourceLocation ENTITIES_CAVE_SPIDER = inject(new ResourceLocation("entities/cave_spider"));
        public static final ResourceLocation ENTITIES_SPIDER = inject(new ResourceLocation("entities/spider"));
        public static final ResourceLocation ENTITIES_ZOMBIE = inject(new ResourceLocation("entities/zombie"));
        public static final ResourceLocation ENTITIES_SKELETON = inject(new ResourceLocation("entities/skeleton"));
        public static final ResourceLocation ENTITIES_CREEPER = inject(new ResourceLocation("entities/creeper"));
        public static final ResourceLocation ENTITIES_ENDERMAN = inject(new ResourceLocation("entities/enderman"));
        public static final ResourceLocation ENTITIES_SKELETON_HORSE = inject(new ResourceLocation("entities/skeleton_horse"));
        public static final ResourceLocation ENTITIES_ENDER_DRAGON = inject(new ResourceLocation("entities/ender_dragon"));
        public static final ResourceLocation ENTITIES_GUARDIAN = inject(new ResourceLocation("entities/guardian"));
        public static final ResourceLocation ENTITIES_ELDER_GUARDIAN = inject(new ResourceLocation("entities/elder_guardian"));
        public static final ResourceLocation ENTITIES_WITHER = inject(new ResourceLocation("entities/wither"));

        private Tables() {}

        public static Collection<ResourceLocation> getValues() {
            return MAP.values();
        }

        public static Optional<ResourceLocation> get(ResourceLocation lootTable) {
            return Optional.ofNullable(MAP.get(lootTable));
        }

        private static ResourceLocation inject(ResourceLocation lootTable) {
            ResourceLocation ret = StardewArmory.getId("inject/" + lootTable.getPath());
            MAP.put(lootTable, ret);
            return ret;
        }
    }

    private LootInjector() {}

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        Tables.get(event.getName()).ifPresent(injectorName -> {
            StardewArmory.LOGGER.info("Injecting loot table '{}' into '{}'", injectorName, event.getName());
            event.getTable().addPool(
                    new LootPool.Builder()
                            .name("stardewarmory_injected")
                            .add(LootTableReference.lootTableReference(injectorName))
                            .build()
            );
        });
    }
}