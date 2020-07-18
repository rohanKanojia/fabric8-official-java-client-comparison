package io.kubernetes;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1DeploymentBuilder;
import io.kubernetes.client.util.Config;

import java.io.IOException;
import java.util.Collections;

public class DeploymentDemo {
    public static void main(String[] args) throws IOException, ApiException {

        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);

        V1Deployment v1Deployment = new V1DeploymentBuilder()
                .withNewMetadata().withName("nginx-deployment").addToLabels("app", "nginx").endMetadata()
                .withNewSpec()
                .withReplicas(3)
                .withNewSelector()
                .withMatchLabels(Collections.singletonMap("app", "nginx"))
                .endSelector()
                .withNewTemplate()
                .withNewMetadata().addToLabels("app", "nginx").endMetadata()
                .withNewSpec()
                .addNewContainer()
                .withName("nginx")
                .withImage("nginx:1.7.9")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec()
                .build();

        AppsV1Api appsV1Api = new AppsV1Api();
        v1Deployment = appsV1Api.createNamespacedDeployment("rokumar", v1Deployment, null, null, null);
    }
}
