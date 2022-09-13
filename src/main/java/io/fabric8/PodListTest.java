package io.fabric8;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

public class PodListTest {
    public static void main(String[] args) {
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    client.pods().inAnyNamespace().list()
            .getItems()
            .stream()
            .map(Pod::getMetadata)
            .map(ObjectMeta::getName)
            .forEach(System.out::println);
}
    }
}
