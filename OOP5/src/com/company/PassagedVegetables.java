package com.company;

import com.company.annotations.XmlAttribute;
import com.company.annotations.XmlObject;
import com.company.annotations.XmlTag;

@XmlObject
public class PassagedVegetables {
    @XmlAttribute
    private final int MinutesToPassage = 10;
    @XmlTag
    public String vegetable1 = "Carrots";
    @XmlTag
    private String vegetable2 = "Beet";
    @XmlTag
    public String getvegetable3() {
        return "Potatos";
    }
    @XmlAttribute(tag = "vegetable3", name = "PreferedType")
    private String string = "Beefsteak";
}
