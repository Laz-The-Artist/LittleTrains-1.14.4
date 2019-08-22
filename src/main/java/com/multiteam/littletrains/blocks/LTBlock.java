package com.multiteam.littletrains.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.util.BlockRenderLayer;

public class LTBlock extends Block {

	public LTBlock(Properties properties) {
		super(properties);
	}
	
	public BlockRenderType getRenderType(BlockState state) {
	      return BlockRenderType.MODEL;
	}
	
	public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.CUTOUT;
	}

}
