package com.design.mode.decorator;

/**
 * The top abstract where concrete component and decorator
 * should be derived from
 * Created by zhangfeifei on 2016/12/08.
 */
public interface Component  {
    /**
     * Print string.
     *
     * @param s the s
     */
    public abstract void PrintString(String s);
}