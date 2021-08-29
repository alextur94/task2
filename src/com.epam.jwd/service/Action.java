package com.epam.jwd.service;

import com.epam.jwd.domain.Paragraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor Aleksey Turkov
 * @version 1.0 (29/08/2021)
 */

public class Action {
    private static final Logger logger = LogManager.getLogger(Paragraph.class);

    //This method recovery text
    public static void recoveryText(List<String> list) {
        StringBuilder sb = new StringBuilder();
        String[] text = null;
        String firstLetter = "^[A-Z]";
        for (String blockWords : list) {
            text = blockWords.split(",\\s+|\\.\\s+|\\?\\s+|!\\s+");
        }
        int count = 0;
        if (text != null) {
            for (String str : text) {
                Pattern pattern1 = Pattern.compile(firstLetter);
                Matcher matcher1 = pattern1.matcher(str);
                if (count != 0) {
                    if (matcher1.find()) {
                        sb.append(". ").append(str);
                    } else {
                        sb.append(", ").append(str);
                    }
                } else {
                    sb.append(str);
                }
                count++;
            }
        } else {
            logger.info("Input text not founded");
        }
        System.out.println(sb);
    }

    //Task1
    //Find the largest number of sentences of text that contain the same words
    public static void countWordsInSentences(List<String> sentences) {
        logger.info("Run method: countWordsInSentences");
        int count = 0;
        String word = ("\\s+|,\\s+");
        for (String sentence : sentences) {
            Set<String> set = new HashSet<>();
            int countTemp = 1;
            String[] arr = sentence.split(word);
            for (String s : arr) {
                if (!set.add(s)) { countTemp++; }
            }
            if (countTemp > count){ count = 1;
            } else if (countTemp == count) { count++;
            }
        }
        System.out.println(count);
    }

    //Task2
    //Sentences in ascending order of words
    public static void getSentencesForIncreasingWords(List<String> sentences) {
        logger.info("Run method: getSentencesForIncreasingWords");
        sentences.sort(Comparator.comparing(String::length));
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    //Task3
    //Word in the first, which is not in other sentences
    public static void findWordNotInSentences(List<String> sentences) {
        logger.info("Run method: findWordNotInSentences");
        String reg = ("\\s+|,\\s+");
        int ifYesWord = 0;
        String[] firstSentence = sentences.get(0).split(reg);
        Set<String> set = new HashSet<>();
        for (int i = 1; i < sentences.size(); i++) {
            String[] sentence = sentences.get(i).split(reg);
            set.addAll(Arrays.asList(sentence));
        }
        for (String word : firstSentence) {
            if (set.add(word)) {
                System.out.println("Unique word - " + word);
                ifYesWord = 1;
                break;
            }
        }
        if (ifYesWord == 0) { System.out.println("Unique word missing"); }
    }
}
