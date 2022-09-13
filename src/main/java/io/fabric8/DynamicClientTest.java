package io.fabric8;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

import java.util.Map;

public class DynamicClientTest {
  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      GenericKubernetesResource genericKubernetesResource = client.genericKubernetesResources("v1", "Namespace")
          .withName("default")
          .get();

      Map<String, String> labels = genericKubernetesResource.getMetadata().getLabels();
      labels.put("foo", "bar");
      genericKubernetesResource.getMetadata().setLabels(labels);

      client.genericKubernetesResources("v1", "Namespace")
          .resource(genericKubernetesResource)
          .replace();
    }
  }
}
