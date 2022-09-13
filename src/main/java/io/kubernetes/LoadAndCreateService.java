package io.kubernetes;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Service;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.Yaml;

import java.io.File;
import java.io.IOException;

public class LoadAndCreateService {
    public static void main(String[] args) throws ApiException, IOException {
        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);

        // Load Service YAML manifest into object
        File file = new File(LoadAndCreateService.class.getResource("/test-svc.yaml").getPath());
        V1Service yamlSvc = (V1Service) Yaml.load(file);

        // Apply Service to Kubernetes API
        CoreV1Api api = new CoreV1Api();
        V1Service createResult = api.createNamespacedService("default", yamlSvc, null, null, null, null);

    }
}
