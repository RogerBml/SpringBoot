package com.sgcc.jxd.microservicedwzypgewm.pgewmhandlers;

import com.sgcc.jxd.microservicedwzypgewm.Repository.PgewmRepository;
import com.sgcc.jxd.microservicedwzypgewm.bean.Pgewm;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Component
@RefreshScope
public class Pgewmhandler {
    private PgewmRepository pgewmRepository;

    public Pgewmhandler(PgewmRepository pgewmRepository){
        this.pgewmRepository = pgewmRepository;
    }
   public  Mono<ServerResponse> getAllPgewm(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.pgewmRepository.findAll(), Pgewm.class);

    }

    public  Mono<ServerResponse> createPgewm(ServerRequest request){
        Mono<Pgewm> pgewmMono = request.bodyToMono(Pgewm.class);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.pgewmRepository.saveAll(pgewmMono), Pgewm.class);

    }

    public  Mono<ServerResponse> deletePgewm(ServerRequest request){
        String id = request.pathVariable("id");
        return this.pgewmRepository.findById(id)
                .flatMap(pgewm -> this.pgewmRepository.delete(pgewm)
                        .then(ServerResponse.ok().build())
                .switchIfEmpty(ServerResponse.notFound().build()));

    }

    //@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> requestBodyFlux(@RequestPart("file") FilePart filePart) throws IOException {
        System.out.println(filePart.filename());
        Path tempFile = Files.createTempFile("test", filePart.filename());

        //NOTE 方法一
        AsynchronousFileChannel channel =
                AsynchronousFileChannel.open(tempFile, StandardOpenOption.WRITE);
        DataBufferUtils.write(filePart.content(), channel, 0)
                .doOnComplete(() -> {
                    System.out.println("finish");
                })
                .subscribe();
        return Mono.just(filePart.filename());
    }


}
