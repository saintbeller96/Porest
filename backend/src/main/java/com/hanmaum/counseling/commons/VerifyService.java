package com.hanmaum.counseling.commons;

public interface VerifyService<K, V> {
    void verify(K key, V expectValue);
    void sendVerifyMessage(Object receiver);
}
