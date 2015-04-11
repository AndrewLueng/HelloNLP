/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Administrator
 */
public class MatchingMethod {

    private int maxLen = 5;
    public Dictionary dic;

    public MatchingMethod() throws IOException {
        dic = new Dictionary();
        dic.initialize();
    }

    public MatchingMethod(int maxLen, String path, String charset) throws IOException {
        this.maxLen = maxLen;
        dic = new Dictionary(path, charset);
        dic.initialize();
    }

    public void setMaxLen(int maxLen) {
        this.maxLen = maxLen;
    }


    
    public String MM(String srcStr) {
        String resStr = "";
        
        int length = srcStr.length();
        int head = 0;
        int tail = maxLen < length ? maxLen : length;

        while (head < tail) {
            String word = srcStr.substring(head, tail);
            if (head + 1 == tail || dic.contains(word)) {
                resStr += word + "/ ";
                
                head = tail;
                tail += maxLen;
                if(tail > length) tail = length;
            } else {
                tail--;
            }
        }

        return resStr;
    }

    public String RMM(String srcStr) {
        String resStr = "";

        int length = srcStr.length();
        int head = length - maxLen;
        if(head < 0)  head = 0;
        int tail = length;

        while (head < tail) {
            String word = srcStr.substring(head, tail);
            if (head + 1 == tail || dic.contains(word)) {
                resStr = word + "/ " + resStr;
                
                tail = head;
                head = tail - maxLen;
                if(head < 0)  head = 0;
            } else {
                head++;
            }
        }

        return resStr;
    }
    
    
    
    public ArrayList<String> MMtoList(String srcStr) {
        ArrayList<String> resList = new ArrayList<>();
        
        int length = srcStr.length();
        int head = 0;
        int tail = maxLen < length ? maxLen : length;

        while (head < tail) {
            String word = srcStr.substring(head, tail);
            if (head + 1 == tail || dic.contains(word)) {
                resList.add(word);
                
                head = tail;
                tail += maxLen;
                if(tail > length) tail = length;
            } else {
                tail--;
            }
        }

        return resList;
    }
    
    public ArrayList<String> RMMtoList(String srcStr) {
        ArrayList<String> resList = new ArrayList<>();

        int length = srcStr.length();
        int head = length - maxLen;
        if(head < 0)  head = 0;
        int tail = length;

        while (head < tail) {
            String word = srcStr.substring(head, tail);
            if (head + 1 == tail || dic.contains(word)) {
                resList.add(word);
                tail = head;
                head = tail - maxLen;
                if(head < 0)  head = 0;
            } else {
                head++;
            }
        }

        Collections.reverse(resList);
        return resList;
    }
}
