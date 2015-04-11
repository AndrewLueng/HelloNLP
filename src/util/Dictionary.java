/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Dictionary {

    String dicPath = "src/src/chineseDic.txt";
    String dicCharset = "utf-8";
//    int size;
    HashSet<String> dicSet = new HashSet<>();

    public Dictionary() {
    }

    public Dictionary(String path, String charset) throws IOException {
        dicPath = path;
        dicCharset = charset;
    }

    public void setDicPath(String dicPath){
        this.dicPath = dicPath;
    }
    public void setDicCharset(String dicCharset){
        this.dicCharset = dicCharset;
    }
    /**
     * 初始化，将字典读入内存备用
     * @throws IOException 
     */
    public void initialize() throws IOException {
        File f = new File(dicPath);
        BufferedReader bf;


        bf = new BufferedReader(new InputStreamReader(new FileInputStream(f), dicCharset));
        String s;
        while ((s = bf.readLine()) != null) {
            s = s.replaceAll(",.*", "");
            dicSet.add(s);
        }
        bf.close();

    }

    public boolean contains(String word){
        return dicSet.contains(word);
    }
   
    //什么意思？TODO
    public ArrayList<String> peek(){
        
        int cnt = 50;
        ArrayList<String> list = new ArrayList<>(cnt);
        
        Iterator<String> ite = dicSet.iterator();
        while((cnt-->0) && ite.hasNext()){
            list.add(ite.next());
        }
        
        return list;
    }

    
    public static void main(String[] args) {
        try {
            Dictionary dic = new Dictionary("./chieseDic.txt", "gb2312");
            System.out.println(dic.dicSet);
        } catch (IOException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
