package com.epam.jwd.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * @autor Aleksey Turkov
 * @version 1.0 (29/08/2021)
 */

public class Paragraph extends Text {
    private static final Logger logger = LogManager.getLogger(Paragraph.class);

    private List<String> paragraphs = new LinkedList<>();

    public Paragraph(Text next) {
        super(next);
    }

    public void addParagraph(String paragraph){
        paragraphs.add(paragraph);
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    @Override
    public void splitText(List<String> list, PartOfTheText pot) {
        String text;
        if(PartOfTheText.PARAGRAPH.equals(pot)){
            text = list.get(0);
            String[] parag = text.split("(\\r?\\n)+");
            for (String tempParag : parag) {
                addParagraph(tempParag);
            }
            logger.info("A paragraph object is created");
        } else if (getNext() != null){
            text = list.get(0);
            String[] parag = text.split("(\\r?\\n)+");
            for (String tempParag : parag) {
                addParagraph(tempParag);
            }
            getNext().splitText(list, pot);
            logger.info("A paragraph object is created");
        }
    }
}
