package com.gmail.visualbukkit.blocks.definitions.core;

import com.gmail.visualbukkit.VisualBukkitApp;
import com.gmail.visualbukkit.blocks.BlockDefinition;
import com.gmail.visualbukkit.blocks.ContainerBlock;
import com.gmail.visualbukkit.blocks.parameters.CheckBoxParameter;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildInfo;
import com.gmail.visualbukkit.reflection.ClassInfo;

import java.net.URI;

@BlockDefinition(id = "stat-while-loop", name = "While Loop", description = "Loops while a condition is true")
public class StatWhileLoop extends ContainerBlock {

    private final CheckBoxParameter modeParameter = new CheckBoxParameter("Negated");

    public StatWhileLoop() {
        addParameter("Mode", modeParameter);
        addParameter("Condition", new ExpressionParameter(ClassInfo.of(boolean.class)));
    }

    @Override
    public void openJavadocs() {
        VisualBukkitApp.openURI(URI.create("https://jd.papermc.io/paper/1.21.4/org/bukkit/entity/HumanEntity.html#openInventory(org.bukkit.inventory.Inventory)"));
    }

    @Override
    public String generateJava(BuildInfo buildInfo) {
        return (modeParameter.isSelected() ? "while (!" : "while (") + arg(1, buildInfo) + ") {" + generateChildrenJava(buildInfo) + "}";
    }
}
