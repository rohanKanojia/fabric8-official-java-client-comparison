package io.kubernetes.customresource;

import com.google.gson.annotations.SerializedName;
import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.models.V1ObjectMeta;

public class Dummy implements KubernetesObject {
    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("kind")
    private String kind;

    @SerializedName("metadata")
    private V1ObjectMeta metadata;

    @SerializedName("spec")
    private DummySpec spec;

    @SerializedName("status")
    private DummyStatus status;

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

    public DummySpec getSpec() {
        return spec;
    }

    public void setSpec(DummySpec spec) {
        this.spec = spec;
    }

    public DummyStatus getStatus() {
        return status;
    }

    public void setStatus(DummyStatus status) {
        this.status = status;
    }

    public void setApiVersion(String version) {
        this.apiVersion = version;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
