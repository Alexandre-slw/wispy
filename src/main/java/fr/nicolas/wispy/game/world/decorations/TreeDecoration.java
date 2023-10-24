package fr.nicolas.wispy.game.world.decorations;

import fr.nicolas.wispy.game.blocks.Blocks;
import fr.nicolas.wispy.game.world.chunks.Chunk;

public class TreeDecoration extends Decoration {

    @Override
    public int[][] getBlocks() {
        return new int[][] {
                { 0, 0, Blocks.LEAVES.getId(), Blocks.LEAVES.getId(), 0 },
                { 0, 0, Blocks.LEAVES.getId(), Blocks.LEAVES.getId(), Blocks.LEAVES.getId() },
                { Blocks.LOG.getId(), Blocks.LOG.getId(), Blocks.LEAVES.getId(), Blocks.LEAVES.getId(), Blocks.LEAVES.getId() },
                { 0, 0, Blocks.LEAVES.getId(), Blocks.LEAVES.getId(), Blocks.LEAVES.getId() },
                { 0, 0, Blocks.LEAVES.getId(), Blocks.LEAVES.getId(), 0 },
        };
    }

    @Override
    public boolean testBase(Chunk chunk, int x, int y) {
        return testSpace(chunk, x, y) && chunk.getBlock(x, y + 1).getType() == Blocks.GRASS && chunk.getBlock(x + 1, y).getType() != Blocks.LOG && chunk.getBlock(x - 1, y).getType() == Blocks.LOG;
    }

    @Override
    public boolean testSpace(Chunk chunk, int x, int y) {
        return chunk.getBlock(x, y).getType() == Blocks.AIR;
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public double getChance() {
        return 0.1;
    }

    @Override
    public boolean areBlocksNonCollidable() {
        return true;
    }
}
