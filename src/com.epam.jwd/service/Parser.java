package com.epam.jwd.service;

import com.epam.jwd.domain.Paragraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor Aleksey Turkov
 * @version 1.0 (29/08/2021)
 */

public class Parser {
    private static final Logger logger = LogManager.getLogger(Paragraph.class);

    public static List<String> parser() {
        List<String> text = new LinkedList<>();
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            br = new BufferedReader(new FileReader("src\\main\\resources\\input.txt"));
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException " + e);
        }
        try {
            sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            logger.error("IOException " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("The stream is not closed " + e);
            }
        }
        text.add(sb.toString());
        return text;
    }
}