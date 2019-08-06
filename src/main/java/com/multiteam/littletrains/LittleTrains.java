package com.multiteam.littletrains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.multiteam.littletrains.init.LTBlockInit;
import com.multiteam.littletrains.init.LTItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LittleTrains.MODID)
public class LittleTrains {
	
	public static LittleTrains instance;
	public static final String MODID = "littletrains";
	private static final Logger LOGGER = LogManager.getLogger();
	public static ItemGroup littletrainsitems;
	
	public LittleTrains() {
		instance = this;
		littletrainsitems = new ItemGroup("littletrainsitems") {
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.COBBLESTONE);
			}
		};
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
    	LOGGER.info("MultiTeam Presents, LittleTrains.");
    }
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void RegisterItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll (
					LTItemInit.debugblock = new BlockItem(LTBlockInit.debugblock, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.debugblock.getRegistryName()),
					LTItemInit.debug = new Item(new Item.Properties().group(littletrainsitems)).setRegistryName(l("debug"))
					);
		}
		@SubscribeEvent
		public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll (
					LTBlockInit.debugblock = new Block(Block.Properties.create(Material.WOOD).lightValue(15).hardnessAndResistance(0.5F).sound(SoundType.SAND)).setRegistryName(l("debugblock"))
					);
		}
		private static ResourceLocation l(String name)
		{
			return new ResourceLocation(MODID, name);
		}
	}

}
