package me.nutsjian.vertx.spring.web.configuration;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;
import me.nutsjian.vertx.spring.web.VertxInitFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VertxConfig {
    private static final Logger logger = LoggerFactory.getLogger(VertxConfig.class);

    @Bean
    public Vertx vertx() {
        Vertx vertx = Vertx.vertx();
        logger.info("vertx\t{}", vertx.toString());
        return vertx;
    }

    @Bean
    public Router router() {
        Vertx vertx = this.vertx();
        Router router = Router.router(vertx);
//        router.route().handler(CookieHandler.create());
        router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));
        return router;
    }

    @Bean
    public HttpClient httpClient() {
        return this.vertx().createHttpClient();
    }

    @Bean
    public HttpServer httpServer() {
        return this.vertx().createHttpServer();
    }

    @Bean
    public VertxInitFactory vertxInitFactory() {
        return new VertxInitFactory();
    }
}
