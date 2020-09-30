package com.music.pay.bean;

/**
 * @author yhy
 */
@FunctionalInterface
public interface DataConnection<T> {
   public T connection(String msg);
}
