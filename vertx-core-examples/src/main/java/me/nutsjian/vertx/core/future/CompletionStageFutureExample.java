package me.nutsjian.vertx.core.future;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import java.util.UUID;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class CompletionStageFutureExample {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
//        Future<String> future = vertx.createDnsClient().lookup("vertx.io");
        Future<String> future = vertx.createDnsClient().lookup("www.baidu.com");
        CompletionStage<String> completionStage = future.toCompletionStage().whenComplete((ip, err) -> {
            if (err != null) {
                System.err.println("Could not resolve vertx.io");
                err.printStackTrace();
            } else {
                System.out.println("vertx.io => " + ip);
            }
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Future.fromCompletionStage(completionStage, vertx.getOrCreateContext())
                .flatMap(str -> {
                    String key = UUID.randomUUID().toString();
                    return Future.succeededFuture(key);
                })
                .onSuccess(str -> {
                    System.out.println("We have a result " + str);
                })
                .onFailure(err -> {
                    System.out.println("We have a problem");
                    err.printStackTrace();
                });
    }

}
