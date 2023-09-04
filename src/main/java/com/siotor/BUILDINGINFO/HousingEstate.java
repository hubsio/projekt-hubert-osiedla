package com.siotor.BUILDINGINFO;

import java.util.ArrayList;
import java.util.List;

public class HousingEstate {
    private List<Block> blocks = new ArrayList<>();

    public void addBlock(Block block) {
        blocks.add(block);
    }
    public List<Block> getBlocks() {
        return blocks;
    }

    public HousingEstate() {
        this.blocks = new ArrayList<>();
    }

}

