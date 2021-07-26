package me.nutsjian.vertx.spring.web;
import io.vertx.core.Vertx;
import me.nutsjian.vertx.spring.web.vertx.VertxServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class VertxInitFactory implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(VertxInitFactory.class);
    @Autowired
    private VertxServer vertxServer;
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("init factory ... ");
        Vertx.vertx().deployVerticle(this.vertxServer , handler -> {
            if (handler.succeeded()) {
                logger.info("deployVerticle succeefully");
            }else {
                logger.error("deployVerticle fail : {}" , handler.cause().getLocalizedMessage());
            }
        });
    }
}