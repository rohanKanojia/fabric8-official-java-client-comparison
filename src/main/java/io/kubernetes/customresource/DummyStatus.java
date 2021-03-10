package io.kubernetes.customresource;

public class DummyStatus {
    private String dummyStatus;

    public DummyStatus(String s) {
        this.dummyStatus = s;
    }

    public String getDummyStatus() { return this.dummyStatus; }

    public void setDummyStatus(String s) { this.dummyStatus = s; }
}
