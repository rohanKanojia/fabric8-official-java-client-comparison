package io.kubernetes.customresource;

import io.kubernetes.client.openapi.models.V1ObjectMeta;

import java.io.Serializable;

public class Dummy implements Serializable {
    V1ObjectMeta metadata;

    public Dummy(V1ObjectMeta metadata) {
        this.metadata = metadata;
    }

    public V1ObjectMeta getMetadata() {
        return metadata;
    }

    public void setMetadata(V1ObjectMeta metadata) {
        this.metadata = metadata;
    }

}
