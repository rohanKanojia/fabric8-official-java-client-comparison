package io.kubernetes.customresource;

public class DummySpec {
    private String foo;
    private String bar;

    public DummySpec(String f, String b) {
        this.foo = f;
        this.bar = b;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
