package me.nutsjian.vertx.core.fs;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;

public class VertxFileSystem {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        FileSystem fileSystem = vertx.fileSystem();
        Future<FileProps> future = fileSystem.props("/opt/dev_workspace/mall.txt");

        future.onComplete((AsyncResult<FileProps> ar) -> {
            if (ar.succeeded()) {
                FileProps props = ar.result();
                System.out.println("File size = " + props.size());
            } else {
                System.out.println("Failure: " + ar.cause().getMessage());
            }
        });
    }

}
