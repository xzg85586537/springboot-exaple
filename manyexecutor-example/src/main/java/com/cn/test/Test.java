package com.cn.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by xiao
 * @Classname Test
 * @Description
 * @Date 2020-04-20 16:46
 */
@Slf4j
public class Test {
    public static final int total = 5000;
    public static final int threadTotal = 200;
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(total);
        for (int i = 0; i < total; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    atomicInteger.incrementAndGet();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("异常信息为：" + e);
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("输出信息：" + atomicInteger.get());
    }
}
