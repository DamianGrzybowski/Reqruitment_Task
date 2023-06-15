package pl.DamianGrzybowski;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            Optional<Block> result = findBlockByColorRecursive(block, color);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }

    private Optional<Block> findBlockByColorRecursive(Block block, String color) {
        if (block.getColor().equals(color)) {
            return Optional.of(block);
        }

        if (block instanceof CompositeBlock) {
            CompositeBlock compositeBlock = (CompositeBlock) block;
            for (Block innerBlock : compositeBlock.getBlocks()) {
                Optional<Block> result = findBlockByColorRecursive(innerBlock, color);
                if (result.isPresent()) {
                    return result;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findBlocksByMaterialRecursive(blocks, material);
    }


    private List<Block> findBlocksByMaterialRecursive(List<Block> blocks, String material) {
        List<Block> matchingBlocks = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                matchingBlocks.add(block);
            }
            if (block instanceof CompositeBlock) {
                CompositeBlock compositeBlock = (CompositeBlock) block;
                List<Block> innerMatchingBlocks = findBlocksByMaterialRecursive(compositeBlock.getBlocks(), material);
                matchingBlocks.addAll(innerMatchingBlocks);
            }
        }
        return matchingBlocks;
    }


    public int countBlocks(List<Block> blocks) {
        int count = 0;
        for (Block block : blocks) {
            count++;
            if (block instanceof CompositeBlock) {
                CompositeBlock compositeBlock = (CompositeBlock) block;
                count += countBlocks(compositeBlock.getBlocks());
            }
        }
        return count;
    }

    @Override
    public int count() {
        return countBlocks(blocks);
    }


}
