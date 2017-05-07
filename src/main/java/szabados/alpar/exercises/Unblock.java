package szabados.alpar.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Unblock {
    private int[][] SCREEN;
    private List<Block> blocks;

    public Unblock(int screenHeight, int screenWidth, List<Block> blocks) {
        this.blocks = blocks;
        SCREEN = new int[screenHeight][screenWidth];
        fillScreen(blocks, SCREEN);
    }

    public int performMoves(List<Integer> moves) {
        int moveNumber = 0;

        for (int i = 1; i < moves.size(); i += 2) {
            int id = moves.get(i);
            int steps = moves.get(i + 1);
            if (willClash(id, steps)) {
                return moveNumber;
            } else {
                moveBlock(id, steps);
                moveNumber++;
            }
        }

        return moveNumber;
    }

    private void moveBlock(int blockID, int steps) {
        Block block = findBlock(blocks, blockID);

        if (steps > 0) {
            removeBlockFromScreen(block);
            updateBlock(block, steps);
            refillBlock(block);
        } else {
            removeBlockFromScreen(block);
            updateBlock(block, steps);
            refillBlock(block);
        }
    }

    private void updateBlock(Block block, int steps) {
        if (horizontal(block)) block.x = block.x + (steps);
        else block.y = block.y + (steps);
    }

    private void refillBlock(Block block) {
        for (int i = 0; i < block.length + 1; i++) {
            if (horizontal(block)) SCREEN[block.y][i + block.x] += block.id + 1;
            else SCREEN[i + block.y][block.x] += block.id + 1;
        }
    }

    private void removeBlockFromScreen(Block block) {
        for (int i = 0; i < block.length + 1; i++) {
            if (horizontal(block)) SCREEN[block.y][i + block.x] = 0;
            else SCREEN[i + block.y][block.x] = 0;
        }
    }

    public boolean willClash(int blockID, int steps) {
        Block block = findBlock(blocks, blockID);

        if (steps == 0) return false;
        else if (steps > 0) {
            if (canMoveRightOrUp(steps, block, block.x, block.y, block.length)) return true;
        } else {
            if (canMoveLeftOrDown(steps, block, block.x, block.y)) return true;
        }

        return false;
    }

    private boolean canMoveRightOrUp(int steps, Block block, int blockX, int blockY, int blockLength) {
        if (horizontal(block)) {
            int maxLength = blockLength + blockX;
            if (maxLength + steps >= SCREEN[0].length || isClashing(SCREEN[blockY][maxLength + steps]))
                return true;
        } else {
            int maxLength = blockLength + blockY;
            if (maxLength + steps >= SCREEN.length || isClashing(SCREEN[maxLength + steps][blockX]))
                return true;
        }

        return false;
    }

    private boolean canMoveLeftOrDown(int steps, Block block, int blockX, int blockY) {
        if (horizontal(block)) {
            if (blockX + (steps) < 0 || (isClashing(SCREEN[blockY][blockX + steps]))) return true;
        } else {
            if (blockY + (steps) < 0 || isClashing(SCREEN[blockY + steps][blockX])) return true;
        }

        return false;
    }

    private boolean isClashing(int i) {
        return i >= 1;
    }

    private Block findBlock(List<Block> blocks, int blockID) {
        for (Block block : blocks) {
            if (block.id == blockID) return block;
        }

        throw new IllegalArgumentException("No valid ID found");
    }

    private boolean horizontal(Block block) {
        return Objects.equals(block.orientation, "h");
    }

    private void fillScreen(List<Block> blocks, int[][] screen) {
        for (Block block : blocks) {
            int offset = 1;
            block.y = block.y - offset;
            block.x = block.x - offset;
            block.length = block.length - offset;

            for (int i = 0; i < block.length + 1; i++) {
                if (horizontal(block)) screen[block.y][i + block.x] += block.id + 1;
                else screen[i + block.y][block.x] += block.id + 1;
            }
        }
    }

    public List<Integer> unmovable() {
        List<Integer> ids = new ArrayList<>();
        for (Block block : blocks) {
            if (willClash(block.id, 1) && willClash(block.id, -1)) {
                ids.add(block.id);
            }
        }

        return ids;
    }
}

class Block {
    int id;
    String orientation;
    int x;
    int y;
    int length;

    Block(int id, String orientation, int x, int y, int length) {
        this.id = id;
        this.orientation = orientation;
        this.x = x;
        this.y = y;
        this.length = length;
    }

    Block() {
    }
}
