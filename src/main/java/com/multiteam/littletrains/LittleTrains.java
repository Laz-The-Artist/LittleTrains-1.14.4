package com.multiteam.littletrains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.multiteam.littletrains.blocks.LTBlock;
import com.multiteam.littletrains.blocks.LTTrack;
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
					//Tracks
					LTItemInit.TRACK = new BlockItem(LTBlockInit.TRACK, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.TRACK.getRegistryName()),
					LTItemInit.TRACK_BALLASTED = new BlockItem(LTBlockInit.TRACK_BALLASTED, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.TRACK_BALLASTED.getRegistryName()),
					LTItemInit.TRACK_GRASSPLATED = new BlockItem(LTBlockInit.TRACK_GRASSPLATED, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.TRACK_GRASSPLATED.getRegistryName()),
					
					
					//Other
					LTItemInit.CONTROL_BOX = new BlockItem(LTBlockInit.CONTROL_BOX, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.CONTROL_BOX.getRegistryName()),
					LTItemInit.MODELLER_TABLE = new BlockItem(LTBlockInit.MODELLER_TABLE, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.MODELLER_TABLE.getRegistryName()),
					LTItemInit.TIN_BLOCK = new BlockItem(LTBlockInit.TIN_BLOCK, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.TIN_BLOCK.getRegistryName()),
					LTItemInit.COPPER_BLOCK = new BlockItem(LTBlockInit.COPPER_BLOCK, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.COPPER_BLOCK.getRegistryName()),
					LTItemInit.TIN_ORE = new BlockItem(LTBlockInit.TIN_ORE, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.TIN_ORE.getRegistryName()),
					LTItemInit.COPPER_ORE = new BlockItem(LTBlockInit.COPPER_ORE, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.COPPER_ORE.getRegistryName()),
					LTItemInit.COBBLE_ANDESITE = new BlockItem(LTBlockInit.COBBLE_ANDESITE, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.COBBLE_ANDESITE.getRegistryName()),
					LTItemInit.COBBLE_HARDENED_CLAY = new BlockItem(LTBlockInit.COBBLE_HARDENED_CLAY, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.COBBLE_HARDENED_CLAY.getRegistryName()),
					LTItemInit.BALLAST_BLOCK = new BlockItem(LTBlockInit.BALLAST_BLOCK, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.BALLAST_BLOCK.getRegistryName()),
					LTItemInit.debugblock = new BlockItem(LTBlockInit.debugblock, new Item.Properties().group(littletrainsitems)).setRegistryName(LTBlockInit.debugblock.getRegistryName()),
					LTItemInit.debug = new Item(new Item.Properties().group(littletrainsitems)).setRegistryName(l("debug"))
					);
		}
		@SubscribeEvent
		public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll (
					//Tracks
					LTBlockInit.TRACK = new LTTrack(Block.Properties.create(Material.MISCELLANEOUS)).setRegistryName(l("track")),
					LTBlockInit.TRACK_BALLASTED = new LTTrack(Block.Properties.create(Material.MISCELLANEOUS)).setRegistryName(l("track_ballasted")),
					LTBlockInit.TRACK_GRASSPLATED = new LTTrack(Block.Properties.create(Material.MISCELLANEOUS)).setRegistryName(l("track_grassplated")),
					
					
					//Other
					LTBlockInit.CONTROL_BOX = new LTBlock(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.METAL)).setRegistryName(l("control_box")),
					LTBlockInit.MODELLER_TABLE = new LTBlock(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.METAL)).setRegistryName(l("modeller_table")),
					LTBlockInit.COBBLE_ANDESITE = new LTBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)).setRegistryName(l("cobble_andesite")),
					LTBlockInit.COBBLE_HARDENED_CLAY = new LTBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)).setRegistryName(l("cobble_hardened_clay")),
					LTBlockInit.BALLAST_BLOCK = new LTBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)).setRegistryName(l("ballast_block")),
					LTBlockInit.COPPER_ORE = new LTBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)).setRegistryName(l("copper_ore")),
					LTBlockInit.TIN_ORE = new LTBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)).setRegistryName(l("tin_ore")),
					LTBlockInit.COPPER_BLOCK = new LTBlock(Block.Properties.create(Material.IRON).sound(SoundType.STONE)).setRegistryName(l("copper_block")),
					LTBlockInit.TIN_BLOCK = new LTBlock(Block.Properties.create(Material.IRON).sound(SoundType.STONE)).setRegistryName(l("tin_block")),
					LTBlockInit.debugblock = new LTBlock(Block.Properties.create(Material.WOOD).lightValue(15).hardnessAndResistance(0.5F).sound(SoundType.SAND)).setRegistryName(l("debugblock"))
					);
		}
		private static ResourceLocation l(String name)
		{
			return new ResourceLocation(MODID, name);
		}
	}

}
