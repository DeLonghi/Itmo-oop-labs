package com.company;

import com.company.annotations.XmlAttribute;
import com.company.annotations.XmlObject;
import com.company.annotations.XmlTag;

@XmlObject
public class Bouillon {
    @XmlTag
    private final String meat_on_bone = "Beef";
    @XmlAttribute
    private String TimeToBoil = "2 hours";


}
