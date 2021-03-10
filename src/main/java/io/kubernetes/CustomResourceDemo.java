package io.kubernetes;

import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.util.generic.GenericKubernetesApi;
import io.kubernetes.client.util.generic.KubernetesApiResponse;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.models.V1ObjectMetaBuilder;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.generic.options.CreateOptions;
import io.kubernetes.customresource.Dummy;
import io.kubernetes.customresource.DummyList;
import io.kubernetes.customresource.DummySpec;

import java.io.IOException;

public class CustomResourceDemo {
    public static void main(String[] args) throws IOException, ApiException {
        // Prepare Dummy resource
        Dummy dummy = new Dummy(new V1ObjectMetaBuilder()
                .withName("official-dummy")
                .build());
        dummy.setKind("Dummy");
        dummy.setApiVersion("demo.fabric8.io/v1");
        dummy.setSpec(new DummySpec("foo", "bar"));

        ApiClient apiClient = ClientBuilder.standard().build();
        GenericKubernetesApi<Dummy, DummyList> dummyClient =
                new GenericKubernetesApi<>(Dummy.class, DummyList.class,
                        "demo.fabric8.io", "v1", "dummies", apiClient);

        // Create Dummy
        KubernetesApiResponse<Dummy> createResponse = dummyClient.create("default", dummy, new CreateOptions()).throwsApiException();
        if (!createResponse.isSuccess()) {
            throw new RuntimeException(createResponse.getStatus().toString());
        }
        System.out.println("Created!");

        // List Dummies
        KubernetesApiResponse<DummyList> listResponse = dummyClient.list("default").throwsApiException();
        if (!listResponse.isSuccess()) {
            throw new RuntimeException(listResponse.getStatus().toString());
        }
        DummyList dummyList = listResponse.getObject();
        System.out.printf("%s dummies found in default namespace\n", dummyList.getItems().size());
        dummyList.getItems().stream()
                .map(KubernetesObject::getMetadata)
                .map(V1ObjectMeta::getName)
                .forEach(System.out::println);
    }
}
