package io.fabric8;

import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;

public class InformerTest {
  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      SharedIndexInformer<Node> nodeInformer = client.nodes()
          .inform(new ResourceEventHandler<Node>() {
            @Override
            public void onAdd(Node node) {
              System.out.printf("%s node added", node.getMetadata().getName());
            }

            @Override
            public void onUpdate(Node oldNode, Node newNode) {
              System.out.printf("%s => %s node updated!", oldNode.getMetadata().getName(), newNode.getMetadata().getName());
            }

            @Override
            public void onDelete(Node node, boolean b) {
              System.out.printf("%s DELETED", node.getMetadata().getName());
            }
          }, 30 * 1000L);

      Thread.sleep(10 * 1000L);

      nodeInformer.close();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("interrupted");
    }
  }
}
