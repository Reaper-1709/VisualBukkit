package com.gmail.visualbukkit.blocks.definitions.core;

import com.gmail.visualbukkit.VisualBukkitApp;
import com.gmail.visualbukkit.blocks.BlockDefinition;
import com.gmail.visualbukkit.blocks.ExpressionBlock;
import com.gmail.visualbukkit.project.BuildInfo;
import com.gmail.visualbukkit.reflection.ClassInfo;

import java.net.URI;
import java.util.List;

@BlockDefinition(id = "expr-function-arguments", name = "Function Arguments", description = "The list of arguments passed to a function (must be used in a 'Function' plugin component)")
public class ExprFunctionArguments extends ExpressionBlock {

    @Override
    public void updateState() {
        super.updateState();
        checkForPluginComponent(CompFunction.class);
    }

    @Override
    public void openJavadocs() {
        VisualBukkitApp.openURI(URI.create("https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Function.html"));
    }

    @Override
    public ClassInfo getReturnType() {
        return ClassInfo.of(List.class);
    }

    @Override
    public String generateJava(BuildInfo buildInfo) {
        return "args";
    }
}
