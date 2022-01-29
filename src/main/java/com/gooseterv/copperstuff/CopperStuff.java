package com.gooseterv.copperstuff;

import com.gooseterv.copperstuff.items.RegisterItems;
//import com.gooseterv.copperstuff.items.ItemsEnum;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
//import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import java.util.Arrays;
//import java.util.Random;

@Mod("copperstuff")
public class CopperStuff {
	
	public static final String MOD_ID = "copperstuff";

	//public static final Item[] ALL_ITEMS = Arrays.stream(ItemsEnum.values()).map(Enum::name).toArray(Item[]::new);
	//public static final Item RANDOM_ITEM = ALL_ITEMS[new Random().nextInt(ALL_ITEMS.length)];
	public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(MOD_ID) {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(RegisterItems.COPPER_ROD.get());
		}
	};

	public CopperStuff() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		RegisterItems.ITEMS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}   
