package com.loatonk.character.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@JsonNaming(value = PropertyNamingStrategies.UpperCamelCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterInfo {
    private String serverName;
    private String characterName;
    private int characterLevel;
    private String characterClassName;
    private String itemAvgLevel;
    private String itemMaxLevel;
}
