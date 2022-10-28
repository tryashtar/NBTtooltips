package net.mision_thi.nbttooltips.tooltips;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.mision_thi.nbttooltips.config.ModConfigs;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.nbt.NbtHelper;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TooltipChanger {
    public ArrayList<Text> Main(MinecraftClient client, ItemStack itemStack, ArrayList<Text> list) {
        var recreated = MutableText.of(new TranslatableTextContent("item.nbt_tags", itemStack.getNbt().getKeys().size())).formatted(Formatting.DARK_GRAY);
        int index = list.indexOf(recreated);
        list.remove(index);
        list.add(index, Text.translatable("item.nbt_tags.nbttooltips", NbtHelper.toPrettyPrintedText(itemStack.getNbt())));
        return list;
    }
}
