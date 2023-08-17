package com.siotor;


import java.util.ArrayList;
import java.util.List;

public class HousingEstate {
    private List<Block> blocks;

    public HousingEstate() {
        blocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public List<Block> getBlocks() {
        return blocks;
    }
    public int getTotalApartments() {
        return blocks.stream()
                .mapToInt(block -> block.getApartments().size())
                .sum();
    }

    public int getTotalParkingSpaces() {
        return blocks.stream()
                .mapToInt(block -> block.getParkingSpaces().size())
                .sum();
    }
}
