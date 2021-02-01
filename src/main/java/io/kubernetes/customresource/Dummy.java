package io.kubernetes.customresource;

import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.models.V1ObjectMeta;

public class Dummy implements KubernetesObject {
    private String apiVersion;
    private String kind;
    private V1ObjectMeta metadata;

    public Dummy(V1ObjectMeta metadata) {
        this.metadata = metadata;
    }

    public V1ObjectMeta getMetadata() {
        return metadata;
    }

    public void setMetadata(V1ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @Override
    public String getApiVersion() {
        return apiVersion;
    }

    @Override
    public String getKind() {
        return kind;
    }
}
