package com.epam.jwd.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * @autor Aleksey Turkov
 * @version 1.0 (29/08/2021)
 */

public class Word extends Text {
    private static final Logger logger = LogManager.getLogger(Sentence.class);

    private List<String> words = new LinkedList<>();

    public Word(Text next) {
        super(next);
    }

    public void addWord(String word){
        words.add(word);
    }

    public List<String> getWords() {
        return words;
    }

    @Override
    public void splitText(List<String> list, PartOfTheText pot) {
        if(PartOfTheText.WORD.equals(pot)){
            String[] word = null;
            for (String sentence : list) {
                word = sentence.split("\\s+");
            }
            for (String s : word) {
                addWord(s);
            }
            logger.info("A word object is created");
        } else if (getNext() != null){
            String[] word = null;
            for (String sentence : list) {
                word = sentence.split("\\s+");
            }
            for (String s : word) {
                addWord(s);
            }
            getNext().splitText(list, pot);
            logger.info("A word object is created");
        }
    }
}
