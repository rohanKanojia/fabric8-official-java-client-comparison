package io.kubernetes;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;

import java.io.IOException;

public class TestingPodList {
    public static void main(String[] args) throws ApiException, IOException {
        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();
        V1PodList list =
                api.listPodForAllNamespaces(null,
                        null,
                        null,
                        null,
                        100,
                        null,
                        null,
                        null,
                        null,
                        null);


        list.getItems().stream()
                .map(V1Pod::getMetadata)
                .map(V1ObjectMeta::getName)
                .forEach(System.out::println);
    }
}
