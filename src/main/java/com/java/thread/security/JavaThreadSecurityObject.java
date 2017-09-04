package com.java.thread.security;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangfeifei2 on 2017/8/4.
 */
public class JavaThreadSecurityObject {

    Map<String,Object> concurrentMap = Collections.synchronizedMap(new HashMap<String,Object>());
    Map<String,Object> concurrentHashMap = new ConcurrentHashMap<>();
    AtomicInteger atomicInteger = new AtomicInteger(0);
    BlockingDeque<Map<String,Object>> blockingDeque = new LinkedBlockingDeque<>();
    BlockingQueue<Map<String,Object>> blockingQueue1 = new ArrayBlockingQueue<Map<String, Object>>(10);
    BlockingQueue<Map<String,Object>> blockingQueue2 = new LinkedTransferQueue<Map<String, Object>>();
    BlockingQueue blockingQueue3 = new DelayQueue();

}
