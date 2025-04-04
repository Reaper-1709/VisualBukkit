package com.gmail.visualbukkit.blocks.definitions.core;

import com.gmail.visualbukkit.VisualBukkitApp;
import com.gmail.visualbukkit.blocks.BlockDefinition;
import com.gmail.visualbukkit.blocks.ContainerBlock;
import com.gmail.visualbukkit.blocks.parameters.CheckBoxParameter;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;
import com.gmail.visualbukkit.project.BuildInfo;
import com.gmail.visualbukkit.reflection.ClassInfo;

import java.net.URI;

@BlockDefinition(id = "stat-if-statement", name = "If Statement", description = "Checks if a condition is true")
public class StatIfStatement extends ContainerBlock {

    private final CheckBoxParameter modeParameter = new CheckBoxParameter("Negated");

    public StatIfStatement() {
        addParameter("Mode", modeParameter);
        addParameter("Condition", new ExpressionParameter(ClassInfo.of(boolean.class)));
    }

    @Override
    public void openJavadocs() {
        VisualBukkitApp.openURI(URI.create("https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html"));
    }

    @Override
    public String generateJava(BuildInfo buildInfo) {
        return "if (" + (modeParameter.isSelected() ? "!" : "") + arg(1, buildInfo) + ") {" + getChildStatementHolder().generateJava(buildInfo) + "}";
    }
}
