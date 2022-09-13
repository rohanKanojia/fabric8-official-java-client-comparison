package io.fabric8;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;

public class CustomResourceCreateDemoTypeless {
    public static void main(String[] args) {
try (KubernetesClient client = new KubernetesClientBuilder().build()) {
    // Create Custom Resource Context
    CustomResourceDefinitionContext context = new CustomResourceDefinitionContext
            .Builder()
            .withGroup("demo.fabric8.io")
            .withKind("Dummy")
            .withName("dummies.demo.fabric8.io")
            .withPlural("dummies")
            .withScope("Namespaced")
            .withVersion("v1")
            .build();

    // Load from Yaml
    GenericKubernetesResource dummyObject = client.genericKubernetesResources(context)
        .load(CustomResourceCreateDemoTypeless.class.getResourceAsStream("/dummy-cr.yml"))
        .get();
    // Create Custom Resource
    client.genericKubernetesResources(context).inNamespace("default").resource(dummyObject).create();
    System.out.println("Created!");

    GenericKubernetesResourceList list = client.genericKubernetesResources(context).inNamespace("default").list();
    System.out.printf("%d items found in default namespace\n", list.getItems().size());
}
    }
}
