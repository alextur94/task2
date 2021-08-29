package com.epam.jwd.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * @autor Aleksey Turkov
 * @version 1.0 (29/08/2021)
 */

public class Sentence extends Text {
    private static final Logger logger = LogManager.getLogger(Sentence.class);

    private List<String> sentences = new LinkedList<>();

    public Sentence(Text next) {
        super(next);
    }

    public void addSentence(String sentence){
        sentences.add(sentence);
    }

    public List<String> getSentences() {
        return sentences;
    }

    @Override
    public void splitText(List<String> list, PartOfTheText pot) {
        if(PartOfTheText.SENTENCE.equals(pot)){
            String[] sent = null;
            for (String sentence : list) {
                sent = sentence.split("\\.\\s*|\\?\\s*|!\\s*");
            }
            for (String s : sent) {
                addSentence(s);
            }
            logger.info("A sentence object is created");
        } else if (getNext() != null){
            String[] sent = null;
            for (String sentence : list) {
                sent = sentence.split("\\.\\s*|\\?\\s*|!\\s*");
            }
            for (String s : sent) {
                addSentence(s);
            }
            getNext().splitText(list, pot);
            logger.info("A sentence object is created");
        }
    }
}
