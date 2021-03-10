package io.kubernetes.customresource;

import io.kubernetes.client.common.KubernetesListObject;
import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.models.V1ListMeta;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DummyList implements KubernetesListObject {
    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("kind")
    private String kind;

    @SerializedName("metadata")
    private V1ListMeta metadata;

    @SerializedName("items")
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
        return "DummyList";
    }
}
