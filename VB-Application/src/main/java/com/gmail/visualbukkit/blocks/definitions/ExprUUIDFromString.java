package com.gmail.visualbukkit.blocks.definitions;

import com.gmail.visualbukkit.blocks.Expression;
import com.gmail.visualbukkit.blocks.parameters.ExpressionParameter;

import java.util.UUID;

public class ExprUUIDFromString extends Expression {

    public ExprUUIDFromString() {
        super("expr-uuid-from-string", UUID.class);
    }

    @Override
    public Block createBlock() {
        return new Block(this, new ExpressionParameter(String.class)) {
            @Override
            public String toJava() {
                return "UUID.fromString(" + arg(0) + ")";
            }
        };
    }
}
