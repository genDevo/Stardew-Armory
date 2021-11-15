package net.gendevo.stardewarmory.entities;

import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtCustomerGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class GuildMasterEntity extends CreatureEntity {

    public static final Ingredient TEMPTATION_ITEM = Ingredient.of(ModItems.PRISMATIC_SHARD.get());


    public GuildMasterEntity(EntityType<? extends CreatureEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new TemptGoal(this, 1.1D, TEMPTATION_ITEM, false));
        this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 6.0F));
//        this.goalSelector.addGoal(2, new MoveToBlockGoal() {
//            @Override
//            protected boolean isValidTarget(IWorldReader p_179488_1_, BlockPos p_179488_2_) {
//                return false;
//            }
//        });
    }

    @Override
    protected int getExperienceReward(PlayerEntity p_70693_1_) { return 10; }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.WANDERING_TRADER_AMBIENT; }


    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.DONKEY_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DONKEY_DEATH;
    }
}
