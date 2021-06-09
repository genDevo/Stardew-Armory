package net.gendevo.stardewarmory.init;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
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

        public static final ResourceLocation CHESTS_IGLOO = inject(LootTables.IGLOO_CHEST);
        public static final ResourceLocation CHESTS_SPAWN = inject(LootTables.SPAWN_BONUS_CHEST);
        public static final ResourceLocation CHESTS_VILLAGE_TEMPLE = inject(LootTables.VILLAGE_TEMPLE);
        public static final ResourceLocation CHESTS_VILLAGE_WEAPONSMITH = inject(LootTables.VILLAGE_WEAPONSMITH);
        public static final ResourceLocation CHESTS_NETHER_BRIDGE = inject(LootTables.NETHER_BRIDGE);
        public static final ResourceLocation CHESTS_SHIP = inject(LootTables.SHIPWRECK_SUPPLY);
        public static final ResourceLocation CHESTS_PILLAGER = inject(LootTables.PILLAGER_OUTPOST);
        public static final ResourceLocation CHESTS_RUINED_PORTAL = inject(LootTables.RUINED_PORTAL);
        public static final ResourceLocation CHESTS_UNDERWATER_RUINS = inject(LootTables.UNDERWATER_RUIN_BIG);
        public static final ResourceLocation CHESTS_STRONGHOLD = inject(LootTables.SIMPLE_DUNGEON);
        public static final ResourceLocation CHESTS_MINESHAFT = inject(LootTables.ABANDONED_MINESHAFT);

        public static final ResourceLocation ENTITIES_CAVE_SPIDER = inject(new ResourceLocation("entities/cave_spider"));
        public static final ResourceLocation ENTITIES_SPIDER = inject(new ResourceLocation("entities/spider"));
        public static final ResourceLocation ENTITIES_ZOMBIE = inject(new ResourceLocation("entities/zombie"));
        public static final ResourceLocation ENTITIES_SKELETON = inject(new ResourceLocation("entities/skeleton"));
        public static final ResourceLocation ENTITIES_SKELETON_HORSE = inject(new ResourceLocation("entities/skeleton_horse"));
        public static final ResourceLocation ENTITIES_ENDER_DRAGON = inject(new ResourceLocation("entities/ender_dragon"));
       

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
                            .name("testomodo_injected")
                            .add(TableLootEntry.lootTableReference(injectorName))
                            .build()
            );
        });
    }
}