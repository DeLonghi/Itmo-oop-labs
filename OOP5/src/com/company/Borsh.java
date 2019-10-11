package com.company;


import com.company.annotations.XmlAttribute;
import com.company.annotations.XmlObject;
import com.company.annotations.XmlTag;

@XmlObject
public class Borsh {

    @XmlAttribute
    private String TotalCoockingTime() {
        return "2.5 hours";
    }

    @XmlTag
    private Bouillon bouillon = new Bouillon();
    @XmlTag
    private PassagedVegetables passagedVegetables = new PassagedVegetables();
}
