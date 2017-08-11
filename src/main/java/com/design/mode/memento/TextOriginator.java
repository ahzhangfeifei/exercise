package com.design.mode.memento;

import java.util.LinkedList;

/**
 *  Our test Originator class with Memento class.
 *  Put 2 class into 1 file, so Memento member can be  visited by Originator
 */
public class TextOriginator  {
    private StringBuffer strbuf = new StringBuffer();
    private String state = "";
    private TextMemento memo;

    /**
     * Instantiates a new Text originator.
     */
    public TextOriginator() {
        memo = new TextMemento();
    }

    /**
     * Add text.
     *
     * @param addStr the add str
     */
    public void addText(String addStr) {
        state = addStr;
        strbuf.append(addStr);
    }

    /**
     * Create memento.
     */
    public void createMemento() {
        memo.addMemo(state);
    }

    /**
     * Sets memento.
     */
    public void setMemento() {
        String tmp = memo.getState();
        if(tmp != null) {            
            int start = strbuf.length() - tmp.length();
            int end = strbuf.length();
            if(start >= 0) {
                strbuf.delete(start,  end);
            } else {
                System.out.println("Get Memo Error !");
            }
        }
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return strbuf.toString();
    }
}

/**
 * The type Text memento.
 */
class TextMemento {
    /**
     * The .
     */
//String state;
    int i = 0;
    /**
     * The Memo list.
     */
    LinkedList memoList;

    /**
     * Instantiates a new Text memento.
     */
    TextMemento() {
        //state = null;
        memoList = new LinkedList();
    }

    /**
     * Add memo.
     *
     * @param state the state
     */
    void addMemo(String state) {
        memoList.addLast(state);
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    String getState() {
        if(memoList.size() != 0) {
            String tmp = (String)memoList.getLast();
            memoList.removeLast();
            return tmp;
        } else {
            return null;
        }      
    }
}