//package jcccParser;
package com.example.wenwen.jcccadmissionsstudentonboardingapp;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/* class that takes a URL, and can parse the content to 
 * our mobile app
 */
public class JCCCParser {
    public String url;
    public String content;

    public JCCCParser(String url)
    {
        this.url = url;
        this.content = this.parseToString();
    }
    // Returns the content of the JCCCParser as a string
    public String parseToString()
    {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Element content = doc.getElementById("content");
        Elements images = content.getElementsByTag("img");
        for (Element image : images) {
            image.attr("src", image.absUrl("src"));
        }
        return content.toString();
    }

    //Writes content of parsed JCCC website to file named filename
    public void writeToFile(String filename)
    {
        try {
            File file = new File(filename);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

