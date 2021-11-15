//package net.gendevo.stardewarmory;
//
//import net.gendevo.stardewarmory.items.SoulSapperRing;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.potion.EffectInstance;
//import net.minecraft.potion.Effects;
//import net.minecraft.util.EntityDamageSource;
//import net.minecraftforge.event.entity.living.LivingDeathEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import top.theillusivec4.curios.api.CuriosApi;
//import top.theillusivec4.curios.api.SlotTypePreset;
//
//public class RingKillEffect {
//    @SubscribeEvent
//    public void playerKill (LivingDeathEvent event) {
//        if (event.getSource() instanceof EntityDamageSource) {
//            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
//            //if (CuriosApi.getCuriosHelper().getEquippedCurios(player) )
//            player.addEffect(new EffectInstance(Effects.GLOWING, 200, 5));
//            System.out.println(CuriosApi.getCuriosHelper().getEquippedCurios(player).toString());
//        }
//    }
//
//
//}
