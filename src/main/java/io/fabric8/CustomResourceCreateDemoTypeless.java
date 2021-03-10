package io.fabric8;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CustomResourceCreateDemoTypeless {
    public static void main(String[] args) {
try (KubernetesClient client = new DefaultKubernetesClient()) {
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
    Map<String, Object> dummyObject = client.customResource(context)
            .load(CustomResourceCreateDemoTypeless.class.getResourceAsStream("/dummy-cr.yml"));
    // Create Custom Resource
    client.customResource(context).create("default", dummyObject);
    System.out.println("Created!");

    Map<String, Object> list = client.customResource(context).list("default");
    System.out.printf("%d items found in default namespace\n", ((List<Object>)list.get("items")).size());
} catch (IOException e) {
    e.printStackTrace();
}
    }
}
