package com.company;

import com.company.annotations.XmlAttribute;
import com.company.annotations.XmlObject;
import com.company.annotations.XmlTag;
import org.dom4j.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;


public class Converter {

    private static final String UNDEF = "UNDEFINED";


    private static void addFieldTag(Field field, Object object, Element rootElement) throws Exception {

        field.setAccessible(true);

        if (field.get(object).getClass().isAnnotationPresent(XmlObject.class)) {
            Element newElement = toXML(field.get(object)).getRootElement();
            rootElement.add(newElement);
        } else {
            String tagName = field.getAnnotation(XmlTag.class).tag();

            if (tagName.equals(UNDEF))
                tagName = field.getName();

            if (rootElement.selectNodes("//" + tagName).size() > 0)
                throw new Exception("Same tag name on the level");

            rootElement.addElement(tagName).addText(field.get(object).toString());
        }

    }

    private static void addFieldAttribute(Field field, Object object, Element rootElement) throws Exception {
        field.setAccessible(true);
        String attributeName = field.getAnnotation(XmlAttribute.class).name();
        String tagName = field.getAnnotation(XmlAttribute.class).tag();


        if (attributeName.equals(UNDEF))
            attributeName = field.getName();

        if (tagName.equals(UNDEF))
            tagName = rootElement.getName();


        List<Node> foundTags = rootElement.selectNodes("//" + tagName);
//        System.out.println(foundTags.size());

        if (foundTags.isEmpty())
            throw new Exception("Tag is not declared");

        List<Attribute> attributes = ((Element) foundTags.get(0)).attributes();
        for (Attribute attr : attributes) {
            if (attr.getName().equals(attributeName))
                throw new Exception("Repeating attribute`s name");

        }

        ((Element) foundTags.get(0)).addAttribute(attributeName, field.get(object).toString());

    }

    private static void addMethodTag(Method method, Object object, Element rootElement) throws Exception {
        if (method.getParameterCount() > 0)
            throw new Exception("Method has parametrs");

        if (method.getReturnType() == void.class)
            throw new Exception("Method returns void");

        method.setAccessible(true);
        String tagName = method.getAnnotation(XmlTag.class).tag();

        if (tagName.equals(UNDEF)) {
            tagName = method.getName();
            if (tagName.matches("^get.+"))
                tagName = tagName.replaceFirst("get", "");
        }

        if (rootElement.selectNodes("//" + tagName).size() > 0)
            throw new Exception("Same tag name on the level");

        rootElement.addElement(tagName).addText(method.invoke(object).toString());

    }

    private static void addAMethodAttribute(Method method, Object object, Element rootElement) throws Exception {
        if (method.getParameterCount() > 0)
            throw new Exception("Method has parametrs");

        if (method.getReturnType() == void.class)
            throw new Exception("Method returns void");

        method.setAccessible(true);
        String tagName = method.getAnnotation(XmlAttribute.class).tag();
        String attributeName = method.getAnnotation(XmlAttribute.class).name();

        if (tagName.equals(UNDEF))
            tagName = rootElement.getName();

        List<Node> foundTags = rootElement.selectNodes("//" + tagName);
        if (foundTags.isEmpty())
            throw new Exception("Tag is not declared");

        if (attributeName.equals(UNDEF)) {
            attributeName = method.getName();
            if (attributeName.matches("^get.+"))
                attributeName = attributeName.replaceFirst("get", "");
        }

        List<Attribute> attributes = ((Element) foundTags.get(0)).attributes();
        for (Attribute attr : attributes) {
            if (attr.getName().equals(attributeName))
                throw new Exception("Repeating attribute`s name");
        }

        ((Element) foundTags.get(0)).addAttribute(attributeName, method.invoke(object).toString());
    }

    public static Document toXML(Object obj) throws Exception {
        Document doc;
        Element rootElement;
        Object object;

        Class clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(XmlObject.class))
            throw new Exception("Class doesn`t contain annotation");

        object = obj;
        doc = DocumentHelper.createDocument();
        rootElement = doc.addElement(clazz.getSimpleName());
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();

        for (Field field : fields)
            if (field.isAnnotationPresent(XmlTag.class))
                addFieldTag(field, object, rootElement);


        for (Method method : methods)
            if (method.isAnnotationPresent(XmlTag.class))
                addMethodTag(method, object, rootElement);


        for (Field field : fields)
            if (field.isAnnotationPresent(XmlAttribute.class))
                addFieldAttribute(field, object, rootElement);

        for (Method method : methods)
            if (method.isAnnotationPresent(XmlAttribute.class))
                addAMethodAttribute(method, object, rootElement);

        return doc;
    }
}
