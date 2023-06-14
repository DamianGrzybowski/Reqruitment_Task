package pl.DamianGrzybowski;

import sun.jvm.hotspot.opto.Block;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure{
    private List<Block> blocks;


    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {

        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

}
