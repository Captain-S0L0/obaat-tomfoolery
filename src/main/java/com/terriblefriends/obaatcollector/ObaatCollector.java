package com.terriblefriends.obaatcollector;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

public class ObaatCollector implements ModInitializer {
    public static List<Item> desireableItems = new ArrayList<>();
    public static List<Block> desireableBlocks = new ArrayList<>();

    static {
        desireableItems.add(Items.COMMAND_BLOCK);
        desireableItems.add(Items.COMMAND_BLOCK_MINECART);
        desireableItems.add(Items.REPEATING_COMMAND_BLOCK);
        desireableItems.add(Items.CHAIN_COMMAND_BLOCK);
        desireableItems.add(Items.JIGSAW);
        desireableItems.add(Items.STRUCTURE_BLOCK);
        desireableItems.add(Items.STRUCTURE_VOID);
        desireableItems.add(Items.DEBUG_STICK);
        desireableItems.add(Items.KNOWLEDGE_BOOK);
        desireableItems.add(Items.PLAYER_HEAD);
        desireableItems.add(Items.PETRIFIED_OAK_SLAB);
        desireableItems.add(Items.BARRIER);
        desireableItems.add(Items.LIGHT);

        desireableBlocks.add(Blocks.COMMAND_BLOCK);
        desireableBlocks.add(Blocks.REPEATING_COMMAND_BLOCK);
        desireableBlocks.add(Blocks.CHAIN_COMMAND_BLOCK);
        desireableBlocks.add(Blocks.JIGSAW);
        desireableBlocks.add(Blocks.STRUCTURE_BLOCK);
        desireableBlocks.add(Blocks.STRUCTURE_VOID);
        desireableBlocks.add(Blocks.PLAYER_HEAD);
        desireableBlocks.add(Blocks.PETRIFIED_OAK_SLAB);
        desireableBlocks.add(Blocks.BARRIER);
        desireableBlocks.add(Blocks.LIGHT);
    }

    @Override
    public void onInitialize() {

    }
}
