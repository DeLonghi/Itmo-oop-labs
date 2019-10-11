package com.company;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        Borsh borsh = new Borsh();

        try {
            FileWriter fw = new FileWriter("output.xml");
            XMLWriter writer = new XMLWriter(fw, OutputFormat.createPrettyPrint());
            writer.write(Converter.toXML(borsh));
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
