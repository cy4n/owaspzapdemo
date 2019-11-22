package de.synyx.zapdemo;

public class BazDto {
    private String baz;

    public BazDto() {
    }

    @Override
    public String toString() {
        return "BazDto{" +
                "baz='" + baz + '\'' +
                '}';
    }

    public BazDto(String baz) {
        this.baz = baz;
    }
    public String getBaz() {
        return baz;
    }

    public void setBaz(String baz) {
        this.baz = baz;
    }



}
