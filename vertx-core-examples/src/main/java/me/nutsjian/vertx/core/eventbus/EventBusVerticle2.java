package me.nutsjian.vertx.core.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

public class EventBusVerticle2 extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        EventBus eb = vertx.eventBus();

        eb.publish("mall.pay", "Yay! I pay for it with publish method");

//        eb.send("mall.pay", "Yay! I pay for it with send method");
    }

}
