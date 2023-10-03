package cn.starry.skywars.proxy.enums;

import lombok.Getter;

public enum Cages {
    DEFAULT("Default"),
    AIR("Air");

    @Getter
    String schem;

    Cages(String schem) {
        this.schem = schem;
    }
}
