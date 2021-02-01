package io.fabric8;

import io.fabric8.customresource.Dummy;
import io.fabric8.customresource.DummySpec;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public class CustomResourceCreateDemo {
    public static void main(String[] args) {

        try (KubernetesClient client = new DefaultKubernetesClient()) {
            // Create Dummy object
            Dummy dummy = getDummy();

            // Dummy Client
            MixedOperation<Dummy, KubernetesResourceList<Dummy>, Resource<Dummy>> dummyClient = client.customResources(Dummy.class);
            // Using Dummy Client to create Dummy resource
            dummyClient.inNamespace("default").createOrReplace(dummy);
        }

    }

    private static Dummy getDummy() {
        Dummy dummy = new Dummy();
        dummy.setMetadata(new ObjectMetaBuilder().withName("dummy1").build());
        DummySpec dummySpec = new DummySpec();
        dummySpec.setBar("fur");
        dummySpec.setFoo("goo");
        dummy.setSpec(dummySpec);

        return dummy;
    }
}
