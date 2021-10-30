package net.smartservers.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SmartPlatformType {

    BUNGEECORD("BungeeCord"),
    SPIGOT("Spigot"),
    SPONGE("Sponge"),
    STANDALONE("Standalone"),
    VELOCITY("Velocity");

    private final String platformName;
}
