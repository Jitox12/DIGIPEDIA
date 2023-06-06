package com.DIGIPEDIA.Digimon.Collection.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConfigurationProperties(prefix = "digivolution")
@Configuration
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DigivolutionCodes {
    private Map<String, String> involution;
    private Map<String, String> evolution;
}
