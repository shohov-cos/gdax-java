package com.coinbase.exchange.api.exchange;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;

public class JsonBodySubscriber<T> implements HttpResponse.BodySubscriber<T> {

    private final HttpResponse.BodySubscriber<InputStream> ioSubscriber = HttpResponse.BodySubscribers.ofInputStream();

    private final ObjectMapper objectMapper;
    private final TypeReference<T> typeReference;

    private JsonBodySubscriber(ObjectMapper objectMapper, TypeReference<T> typeReference) {
        this.objectMapper = objectMapper;
        this.typeReference = typeReference;
    }

    public static <T> JsonBodySubscriber<T> ofJson(ObjectMapper objectMapper, TypeReference<T> typeReference) {
        return new JsonBodySubscriber<>(objectMapper, typeReference);
    }

    @Override
    public CompletionStage<T> getBody() {
        return ioSubscriber.getBody().thenApply(ioStream -> {
            try {
                return objectMapper.readValue(ioStream, typeReference);
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        });
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        ioSubscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(List<ByteBuffer> item) {
        ioSubscriber.onNext(item);
    }

    @Override
    public void onError(Throwable throwable) {
        ioSubscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        ioSubscriber.onComplete();
    }
}
