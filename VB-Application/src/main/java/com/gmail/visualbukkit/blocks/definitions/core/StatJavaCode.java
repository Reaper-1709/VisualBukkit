package com.gmail.visualbukkit.blocks.definitions.core;

import com.gmail.visualbukkit.VisualBukkitApp;
import com.gmail.visualbukkit.blocks.BlockDefinition;
import com.gmail.visualbukkit.blocks.StatementBlock;
import com.gmail.visualbukkit.blocks.parameters.MultilineInputParameter;
import com.gmail.visualbukkit.project.BuildInfo;

import java.net.URI;

@BlockDefinition(id = "stat-java-code", name = "Java Code", description = "Arbitrary Java code")
public class StatJavaCode extends StatementBlock {

    public StatJavaCode() {
        addParameter("Java", new MultilineInputParameter());
    }

    @Override
    public void openJavadocs() {
        VisualBukkitApp.openURI(URI.create("https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html"));
    }

    @Override
    public String generateJava(BuildInfo buildInfo) {
        return arg(0, buildInfo);
    }
}
