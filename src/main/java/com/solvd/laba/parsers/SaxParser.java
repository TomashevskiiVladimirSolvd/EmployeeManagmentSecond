package com.solvd.laba.parsers;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {
    public void parseSaxXML(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            XMLHandler xmlHandler = new XMLHandler();
            parser.parse(xmlFile, xmlHandler);

        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("Can't parse it");
        }
    }
}



