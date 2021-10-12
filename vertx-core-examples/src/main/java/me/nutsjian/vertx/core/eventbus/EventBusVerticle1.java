package me.nutsjian.vertx.core.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;

public class EventBusVerticle1 extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        EventBus eb = vertx.eventBus();

        eb.consumer("mall.pay", message -> {
            System.out.println("I have received a message " + message.body());
        });

        vertx.setTimer(3000, handler -> {
            eb.send("mall.pay", "Yay! I pay for it with send method " + handler.intValue());
        });

//        MessageConsumer<Object> consumer = eb.consumer("maill.pay");
//        consumer.handler(message -> {
//            System.out.println("I have received a message " + message.body());
//        });
//
//        使用异步
//        consumer.completionHandler(res -> {
//            if (res.succeeded()) {
//                System.out.println("The handler registration has reached all nodes");
//            } else {
//                System.out.println("Registration failed!");
//            }
//        });
//
//        反注册
//        consumer.unregister(res -> {
//            if (res.succeeded()) {
//                System.out.println("The handler un-registration has reached all nodes");
//            } else {
//                System.out.println("Un-registration failed!");
//            }
//        });
    }

}
