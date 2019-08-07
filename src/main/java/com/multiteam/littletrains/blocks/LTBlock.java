package com.multiteam.littletrains.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.util.BlockRenderLayer;

public class LTBlock extends Block {

	public LTBlock(Properties properties) {
		super(properties);
	}
	
	public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
	}
	
	public boolean isFullCube(BlockState state) {
        return false;
    }
	
    public boolean isNormalCube(BlockState state) {
        return false;
    }
    
    public boolean canCollideCheck(BlockState state, boolean b) {
    	return false;
    }
    
    public boolean isCollidable()
	{
		return true;
	}

}
