package com.example.instance.functional.functions;

import java.util.function.Function;


public interface ValidationFunction extends Function<Integer, Boolean> {

    static ValidationFunction validate1() {
        return num -> num.intValue() > 0;
    }

    static ValidationFunction validate2() {
        return num -> num.intValue() < 10;
    }

    default ValidationFunction and(ValidationFunction next) {
        return num -> this.apply(num) ? next.apply(num) : false;
    }
}
