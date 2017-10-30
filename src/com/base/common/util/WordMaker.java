package com.base.common.util;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Set;  
  
import com.jacob.activeX.ActiveXComponent;  
import com.jacob.com.ComThread;  
import com.jacob.com.Dispatch;  
import com.jacob.com.Variant;  
  
public class WordMaker {  
  
    Map<String, String> info;  
    private String textPath;  
    private static String outWord;  
    protected ActiveXComponent word;  
    protected Dispatch documents;  
    protected Dispatch document;  
    private Dispatch selection;  
  
    protected Dispatch range;  
    protected Dispatch find;  
    protected Dispatch paragraphs;  
    protected Dispatch tables;  
    public static final int wdFindContinue = 1;  
      
    public WordMaker() {
        super();  
    }  
  
    /** 
     * ����������word  
     * @param textPath  ģ���ĵ�·�� 
     * @param outWord   ������ĵ�·�� 
     * @param info   �滻�ı�Map<String,String>  keyҪ�滻���ı� value�滻����ı� 
     */  
    public void buildWord(String textPath, String outWord, Map<String, String> info) {  
           
          
        if (textPath != null && new File(textPath).exists()) {  
            this.info = info;  
            this.textPath = textPath;  
            this.outWord = outWord;  
            initFields();  
        }  
    }  
   
    /** 
     * ��ʼ��jacob��������Dispatch������� 
     *  
     */
    protected void initFields() {  
        try {  
            this.word = new ActiveXComponent("Word.Application"); //  
            this.word.setProperty("Visible", new Variant(false));  
  
            this.documents = this.word.getProperty("Documents").toDispatch();  
  
            this.document = Dispatch.call(this.documents, "Open", textPath)  
                    .toDispatch();  
            this.selection = this.word.getProperty("Selection").toDispatch();  
            this.find = Dispatch.call(this.selection, "Find").toDispatch();  
            this.paragraphs = Dispatch.get(document, "Paragraphs").toDispatch();  
            this.tables = Dispatch.get(document, "Tables").toDispatch();  
            this.range = Dispatch.get(selection, "Range").toDispatch();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            System.out.println(ex.getCause().toString());  
            ex.printStackTrace();  
        }  
        saveAsOutputFile();  
        closeTemplate();  
        insertWord();  
        closeOutWord();  
       // quit();  
        ComThread.Release();
    }  
  
    /** 
     * �������ʽ������� 
     *  
     * @return ������ɵ�doc�ĵ�������� 
     *  
     */  
  
    protected void quit() {  
        if (this.word != null) {  
            this.word.invoke("Quit", new Variant[] {});  
            this.word = null;  
        }  
    }  
  
    protected void saveAsOutputFile() {  
        if (this.document != null) {  
            Dispatch.invoke(this.document, "SaveAs", Dispatch.Method,  
                    new Object[] { this.outWord, new Variant(0) }, new int[1]);  
        }  
    }  
  
    protected void closeTemplate() {  
        if (this.textPath != null && this.document != null) {  
            Dispatch.call(this.document, "Close", new Variant(false));  
            this.document = null;  
        }  
    }  
      
    protected void closeOutWord() {  
        if (this.outWord != null && this.document != null) {  
            Dispatch.call(this.document, "Close", new Variant(false));  
            this.document = null;  
        }  
    }  
  
    public boolean insertWord() {  
        if (info != null && info.size() > 0) {  
            for (Iterator it = info.keySet().iterator(); it.hasNext();) {  
                String lkey = it.next().toString(); // ��  
                String lvalue = (String) info.get(lkey);// ֵ  
                replaceWord(lkey, lvalue);  
            }  
        }  
        return false;  
  
    }  
  
    /** 
     * ���ڸ�ָ����word�ĵ���ĳ���ַ����滻 
     *  
     * @param textPath 
     *            ���滻��word�ĵ� 
     * @param targetWord 
     *            ���滻���ַ� 
     * @param replaceWord 
     *            Ҫ�滻�ɵ��ַ� 
     */  
    public static void replaceWord(String targetWord, String replaceWord) {  
        ActiveXComponent app = new ActiveXComponent("Word.Application");// ��word  
        try {  
            app.setProperty("Visible", new Variant(false));// ����word���ɼ�  
            Dispatch docs = app.getProperty("Documents").toDispatch();  
            Dispatch doc = Dispatch.invoke(  
                    docs,  
                    "Open",  
                    Dispatch.Method,  
                    new Object[] { outWord, new Variant(false),  
                            new Variant(false) }, new int[1]).toDispatch();  
            // ��word�ļ���ע�������������Ҫ��Ϊfalse���������ʾ�Ƿ���ֻ�w�ʽ�򿪣�  
            // ��Ϊ����Ҫ����ԭ�ļ��������Կ�д��ʽ�򿪡�  
  
            Dispatch selection = app.getProperty("Selection").toDispatch();// ��ö�Selection���  
            Dispatch.call(selection, "HomeKey", new Variant(6));// �Ƶ���ͷ  
            Dispatch find = Dispatch.call(selection, "Find").toDispatch();// ���Find���  
  
            Dispatch.put(find, "Text", targetWord);// �����ַ�targetWord  
  
            Dispatch.call(find, "Execute");// ִ�в�ѯ  
  
            Dispatch.put(selection, "Text", replaceWord);// �滻ΪreplaceWord  
  
            Dispatch.call(doc, "Save");// ����  
  
            Dispatch.call(doc, "Close", new Variant(false));  
          
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
              
        }  
    }  
   
}  

