package com.gmail.visualbukkit.blocks.definitions.core;

import com.gmail.visualbukkit.VisualBukkitApp;
import com.gmail.visualbukkit.blocks.BlockDefinition;
import com.gmail.visualbukkit.blocks.ContainerBlock;
import com.gmail.visualbukkit.project.BuildInfo;

import java.net.URI;

@BlockDefinition(id = "stat-else-statement", name = "Else Statement", description = "Checks if the condition was false for the previous 'If Statement' or 'Else If Statement'")
public class StatElseStatement extends ContainerBlock {

    @Override
    public void updateState() {
        super.updateState();
        checkForPrevious(StatIfStatement.class);
    }

    @Override
    public void openJavadocs() {
        VisualBukkitApp.openURI(URI.create("https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html"));
    }

    @Override
    public String generateJava(BuildInfo buildInfo) {
        return "else {" + generateChildrenJava(buildInfo) + "}";
    }
}
