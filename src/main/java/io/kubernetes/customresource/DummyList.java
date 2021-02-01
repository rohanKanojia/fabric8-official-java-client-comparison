package io.kubernetes.customresource;

import io.kubernetes.client.common.KubernetesListObject;
import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.models.V1ListMeta;

import java.util.List;

public class DummyList implements KubernetesListObject {
    private V1ListMeta metadata;
    private List<Dummy> items;

    @Override
    public V1ListMeta getMetadata() {
        return metadata;
    }

    @Override
    public List<? extends KubernetesObject> getItems() {
        return items;
    }

    @Override
    public String getApiVersion() {
        return "demo.fabric8.io/v1";
    }

    @Override
    public String getKind() {
        return "Dummy";
    }
}
