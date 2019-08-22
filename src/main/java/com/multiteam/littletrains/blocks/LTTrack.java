package com.multiteam.littletrains.blocks;

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.block.BlockState;
import net.minecraft.block.FourWayBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SixWayBlock;
import net.minecraft.block.TripWireHookBlock;
import net.minecraft.item.BlockItemUseContext;

import java.util.Map;

import net.minecraft.block.Block;

public class LTTrack extends LTBlock {
	
	protected static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP = SixWayBlock.FACING_TO_PROPERTY_MAP.entrySet().stream().filter((p_199775_0_) -> {
	      return p_199775_0_.getKey().getAxis().isHorizontal();
	   }).collect(Util.toMapCollector());
	
	public static final BooleanProperty TURN90 = BooleanProperty.create("turn90");
	public static final BooleanProperty TURN = BooleanProperty.create("turn");
	public static final BooleanProperty STRAIGHT = BooleanProperty.create("straight");
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final Map<Direction, BooleanProperty> PROPMAP = LTTrack.FACING_TO_PROPERTY_MAP;

	public LTTrack(Properties properties) {
		super(properties);
		this.setDefaultState(stateContainer.getBaseState().with(FACING, Direction.NORTH).with(TURN, false).with(TURN90, false).with(STRAIGHT, true));
	}
	
	/*public BlockState getStateForPlacement(BlockItemUseContext context) {
	    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
	}*/
	
	public BlockState rotate(BlockState state, Rotation rot) {
	    return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING, TURN, TURN90, STRAIGHT);
		super.fillStateContainer(builder);
	}
	
	public boolean shouldConnectTo(BlockState blockblock, Direction dir) {
	      Block block = blockblock.getBlock();
	      if (block == this.getBlock()) {
	         return blockblock.get(LTTrack.FACING) == dir.getOpposite();
	      } else {
	         return block == this;
	      }
	   }
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
	      IBlockReader iblockreader = context.getWorld();
	      BlockPos blockpos = context.getPos();
	      return this.getDefaultState().with(STRAIGHT, Boolean.valueOf(this.shouldConnectTo(iblockreader.getBlockState(blockpos.north()), Direction.NORTH))).with(TURN, Boolean.valueOf(this.shouldConnectTo(iblockreader.getBlockState(blockpos.east()), Direction.EAST))).with(STRAIGHT, Boolean.valueOf(this.shouldConnectTo(iblockreader.getBlockState(blockpos.south()), Direction.SOUTH))).with(TURN90, Boolean.valueOf(this.shouldConnectTo(iblockreader.getBlockState(blockpos.west()), Direction.WEST)));

	   }
	
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
	      return facing.getAxis().isHorizontal() ? stateIn.with(PROPMAP.get(facing), Boolean.valueOf(this.shouldConnectTo(facingState, facing))) : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	   }

}
