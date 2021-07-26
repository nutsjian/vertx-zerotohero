package me.nutsjian.vertx.servicediscovery.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.ServiceDiscoveryOptions;

public class BootServer extends AbstractVerticle {


    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        ServiceDiscovery discovery = ServiceDiscovery.create(vertx,
                new ServiceDiscoveryOptions()
                    .setAnnounceAddress("service-announce")
                    .setName("my-name")
        );



//        ranger  kerberos
//        认证权限，标签实现权限
//        EC -> 引擎 -> 上报信息到 -> linkis-manager
//        

        discovery.close();
    }

}
