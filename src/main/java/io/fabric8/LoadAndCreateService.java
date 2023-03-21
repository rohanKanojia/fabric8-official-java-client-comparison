package io.fabric8;

import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

public class LoadAndCreateService {
    public static void main(String[] args) {
        try (KubernetesClient client = new KubernetesClientBuilder().build()) {
            Service svc = client.services()
                .load(LoadAndCreateService.class.getResourceAsStream("/test-svc.yaml"))
                .get();

            client.services().inNamespace("default").resource(svc).create();
        }
    }
}
