package me.nutsjian.vertx.spring.web.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import me.nutsjian.vertx.spring.web.handler.FailureHandler;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VertxServer extends AbstractVerticle {

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(VertxServer.class);

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private Router router;

    @Autowired
    private HttpServer httpServer;

    @Autowired
    private FailureHandler failureHandler;


    @Override
    public void start() throws Exception {
        super.start();

        Router router = this.router;
        this.httpFailureHandler();
        this.routeStatic();
        this.vertx.createHttpServer().requestHandler(router).listen(this.port);
    }

    private void httpFailureHandler() {
        this.router.route().failureHandler(this.failureHandler::httpFailureHandler);
    }

    private void routeStatic() {
        this.router.route().handler(StaticHandler.create());
//        this.router.route("/*").handler(StaticHandler.create());
    }

}
