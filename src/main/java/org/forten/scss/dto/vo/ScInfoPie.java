package org.forten.scss.dto.vo;

public class ScInfoPie {
    private String name;
    private int value;

    public ScInfoPie() {
    }

    public ScInfoPie(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ScInfoPie{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
