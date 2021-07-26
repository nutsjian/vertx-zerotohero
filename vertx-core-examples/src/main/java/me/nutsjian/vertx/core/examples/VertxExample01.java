package me.nutsjian.vertx.core.examples;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.concurrent.atomic.LongAdder;

public class VertxExample01 {
    private static LongAdder adder = new LongAdder();

    public static void main(String[] args) {
        VertxOptions options = new VertxOptions()
                .setWorkerPoolSize(40);
        Vertx vertx = Vertx.vertx(options);
        vertx.setPeriodic(1000, id -> {
            System.out.println("timer fired! " + adder.intValue());
            adder.increment();
        });
    }

}
