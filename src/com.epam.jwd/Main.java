package com.epam.jwd;

import com.epam.jwd.domain.Paragraph;
import com.epam.jwd.domain.PartOfTheText;
import com.epam.jwd.domain.Sentence;
import com.epam.jwd.domain.Word;
import com.epam.jwd.service.Action;
import com.epam.jwd.service.Parser;

/**
 * @autor Aleksey Turkov
 * @version 1.0 (29/08/2021)
 */

public class Main {
    public static void main(String[] args) {
        Word word = new Word(null);
        Sentence sentence = new Sentence(word);
        Paragraph paragraph = new Paragraph(sentence);
        paragraph.splitText(Parser.parser(), PartOfTheText.WORD);
        Action.recoveryText(Parser.parser());

        Action.countWordsInSentences(sentence.getSentences());
        Action.getSentencesForIncreasingWords(sentence.getSentences());
        Action.findWordNotInSentences(sentence.getSentences());
    }
}