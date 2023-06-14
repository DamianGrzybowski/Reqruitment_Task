package pl.DamianGrzybowski;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
