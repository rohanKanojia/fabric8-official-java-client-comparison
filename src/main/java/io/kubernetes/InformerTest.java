package io.kubernetes;

import io.kubernetes.client.informer.ResourceEventHandler;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Node;
import io.kubernetes.client.openapi.models.V1NodeList;
import io.kubernetes.client.util.CallGeneratorParams;
import io.kubernetes.client.util.Config;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InformerTest {
  public static void main(String[] args) throws InterruptedException, IOException {
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);
    CoreV1Api coreV1Api = new CoreV1Api();
    OkHttpClient httpClient =
        client.getHttpClient().newBuilder().readTimeout(0, TimeUnit.SECONDS).build();
    client.setHttpClient(httpClient);

    SharedInformerFactory factory = new SharedInformerFactory(client);

// Node informer
    SharedIndexInformer<V1Node> nodeInformer =
        factory.sharedIndexInformerFor(
            (CallGeneratorParams params) -> {
              return coreV1Api.listNodeCall(
                  null,
                  null,
                  null,
                  null,
                  null,
                  null,
                  params.resourceVersion,
                  null,
                  params.timeoutSeconds,
                  params.watch,
                  null);
            },
            V1Node.class,
            V1NodeList.class);

    nodeInformer.addEventHandler(
        new ResourceEventHandler<V1Node>() {
          @Override
          public void onAdd(V1Node node) {
            System.out.printf("%s node added!\n", node.getMetadata().getName());
          }

          @Override
          public void onUpdate(V1Node oldNode, V1Node newNode) {
            System.out.printf(
                "%s => %s node updated!\n",
                oldNode.getMetadata().getName(), newNode.getMetadata().getName());
          }

          @Override
          public void onDelete(V1Node node, boolean deletedFinalStateUnknown) {
            System.out.printf("%s node deleted!\n", node.getMetadata().getName());
          }
        });

    factory.startAllRegisteredInformers();
    Thread.sleep(10 * 1000L);
    factory.stopAllRegisteredInformers();
  }
}
