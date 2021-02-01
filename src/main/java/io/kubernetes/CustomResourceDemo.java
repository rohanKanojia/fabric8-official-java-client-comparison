package io.kubernetes;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.util.generic.GenericKubernetesApi;
import io.kubernetes.client.util.generic.KubernetesApiResponse;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.models.V1ObjectMetaBuilder;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.customresource.Dummy;
import io.kubernetes.customresource.DummyList;

import java.io.IOException;

public class CustomResourceDemo {
    public static void main(String[] args) throws IOException, ApiException {
        Dummy dummy = new Dummy(new V1ObjectMetaBuilder()
                .withName("dummy1")
                .withNamespace("rokumar")
                .build());
        ApiClient apiClient = ClientBuilder.standard().build();
        GenericKubernetesApi<Dummy, DummyList> podClient =
                new GenericKubernetesApi<>(Dummy.class, DummyList.class,
                                           "dummy.fabric8.io", "v1", "dummies", apiClient);

        KubernetesApiResponse<Dummy> createResponse = podClient.create(dummy).throwsApiException();
        if (!createResponse.isSuccess()) {
            throw new RuntimeException(createResponse.getStatus().toString());
        }
        System.out.println("Created!");
    }
}
