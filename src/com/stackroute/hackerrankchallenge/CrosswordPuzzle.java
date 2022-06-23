package com.stackroute.hackerrankchallenge;

import java.util.Arrays;

public class CrosswordPuzzle {
    private static boolean found = false;

    public static void main(String[] args) {

        String[] crossword1 = {"+-++++++++","+-++++++++","+-++++++++","+-----++++","+-+++-++++",
                "+-+++-++++","+++++-++++", "++------++","+++++-++++", "+++++-++++"};
        String words1 = "LONDON;DELHI;ICELAND;ANKARA";
        String[] puzzle1 = crosswordPuzzle(crossword1, words1);

        for(String word : puzzle1) {
            System.out.println(word);
        }

        System.out.println("");
        found = false;

        String[] crossword2 = {"+-++++++++","+-++++++++","+-------++","+-++++++++","+-++++++++",
                "+------+++","+-+++-++++","+++++-++++","+++++-++++","++++++++++"};
        String words2 = "AGRA;NORWAY;ENGLAND;GWALIOR";
        String[] puzzle2 = crosswordPuzzle(crossword2, words2);

        for(String word : puzzle2) {
            System.out.println(word);
        }

        System.out.println("");
        found = false;

        String[] crossword3 = {"XXXXXX-XXX","XX------XX","XXXXXX-XXX","XXXXXX-XXX","XXX------X",
                "XXXXXX-X-X","XXXXXX-X-X","XXXXXXXX-X","XXXXXXXX-X","XXXXXXXX-X"};
        String words3 = "ICELAND;MEXICO;PANAMA;ALMATY";
        String[] puzzle3 = crosswordPuzzle(crossword3, words3);

        for(String word : puzzle3) {
            System.out.println(word);
        }
    }

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {

        char[][] resultArray = new char[crossword.length][crossword[0].length()];

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length(); j++) {
                resultArray[i][j] = crossword[i].charAt(j);
            }
        }
        char[][] result = occurrence(resultArray, words.split(";"), 0);
        String[] resInString = new String[crossword.length];

        for(int i = 0; i< result.length; i++) {
            resInString[i] = new String(result[i]);
        }

        return resInString;
    }

    private static char[][] occurrence(char[][] crossword, String[] words, int i) {

        if(i == words.length) {
            found = true;
            return crossword;
        }

        for (int j = 0; j < crossword.length; j++) {
            for (int k = 0; k < crossword[j].length; k++) {

                if (crossword[j][k] == '+') {
                    continue;
                }

                // add in row j
                boolean addToRow = canBeAddedToRow(words[i], crossword[j], k);

                if (addToRow) {
                    char newCross[][] = addToRow(words[i], crossword,j, k);
                    char ifAddedToRow[][] = occurrence(newCross, words, i+1);

                    if(found) {
                        return ifAddedToRow;
                    }
                }

                boolean addToColumn = canBeAddedToColumn(words[i], crossword, j, k);

                if (addToColumn) {
                    char newCross[][] = addToColumn(words[i], crossword,j, k);

                    char ifAddedToCol[][] =  occurrence(newCross, words, i+1);
                    if(found) {
                        return ifAddedToCol;
                    }
                }
            }
        }

        return crossword;
    }

    private static char[][] addToColumn(String string, char[][] crossword, int j, int k) {
        char[][] newValue = deepCopy(crossword);

        for(int i = 0; i< string.length(); i++ ) {
            newValue[j+i][k] = string.charAt(i);
        }
        return newValue;
    }

    private static char[][] addToRow(String string, char[][] crossword, int j, int k) {

        char[][] newValue = deepCopy(crossword);

        for(int i = 0; i< string.length(); i++ ) {
            newValue[j][k + i] = string.charAt(i);
        }
        return newValue;
    }

    private static char[][] deepCopy(char[][] crossword) {
        char[][] newValue = new char[crossword.length][crossword[0].length];
        for (int i = 0; i < newValue.length; i++)
            newValue[i] = Arrays.copyOf(crossword[i], crossword[i].length);
        return newValue;
    }

    private static boolean canBeAddedToColumn(String string, char[][] crossword, int j, int k) {
        int wordCounter = 0;

        for (int i = j; i < crossword.length; i++) {
            if (wordCounter == string.length() || string.charAt(wordCounter) != crossword[i][k] && crossword[i][k] != '-') {
                break;
            }
            wordCounter++;
        }

        return (wordCounter == string.length());
    }

    private static boolean canBeAddedToRow(String string, char[] crossword, int k) {
        int wordCounter = 0;

        for (int i = k; i < crossword.length; i++) {
            if (wordCounter == string.length() || string.charAt(wordCounter) != crossword[i] && crossword[i] != '-') {
                break;
            }
            wordCounter++;
        }

        return (wordCounter == string.length());
    }
}
