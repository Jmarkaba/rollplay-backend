package com.jahlapeno.rollplay.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Effect {
    String attributeName;
    double percentChange;
    double intChange;
}
