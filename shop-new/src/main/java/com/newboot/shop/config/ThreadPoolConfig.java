package com.newboot.shop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@Slf4j
public class ThreadPoolConfig {
    /**
     * 核心线程数（默认是1）：若是IO密集型，cpu核心数*2，若是cpu密集型，cpu核心数
     * 核心线程会一直存活，及时没有任务需要执行
     * 设置allowCoreThreadTimeout=true（默认false）时，核心线程会超时关闭
     * 注意：当线程数小于核心线程数时，即使有线程空闲，线程池也会优先创建新线程处理
     */
    @Value("${shop.async.executor.core-pool-size}")
    private int corePoolSize;
    /**
     * 最大线程数，系统默认Integer.MAX_VALUE
     */
    @Value("${shop.async.executor.max-pool-size}")
    private int maxPoolSize;
    /**
     * 缓冲队列大小，系统默认Integer.MAX_VALUE
     * 注意：这个值肯定要改小，不然任务陡增时，都堆在队列中（队列值大），
     * 核心线程数就那几个，无法很快执行队列中的任务，
     * 就会延长响应时间，阻塞任务
     */
    @Value("${shop.async.executor.queue-capacity}")
    private int queueCapacity;
    /**
     * 允许线程空闲时间（单位：默认为秒，默认60S）
     * 当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
     * 如果allowCoreThreadTimeout=true，则会直到线程数量=0
     */
    @Value("${shop.async.executor.keep-alive-seconds}")
    private int keepAliveSeconds;
    /**
     * 线程池名前缀，用于监控识别
     */
    @Value("${shop.async.executor.name-prefix}")
    private String namePrefix;
    /**
     * 允许核心线程超时（默认false）
     */
    @Value("${shop.async.executor.core-thread-timeout}")
    private boolean allowCoreThreadTimeout;
    /**
     * 当任务完成后，长时间无待处理任务时，销毁线程池
     */
    @Value("${shop.async.executor.task-shutdown}")
    private boolean waitForTasksToCompleteOnShutdown;
    /**
     * 线程池中任务的等待时间
     * 如果超过这个时间还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
     */
    @Value("${shop.async.executor.await-seconds}")
    private int awaitTerminationSeconds;

    @Bean(name = "shopTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        log.info("{} set ThreadPoolTaskExecutor.", ThreadPoolConfig.class.toString());
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(namePrefix);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
        executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        // 设置任务拒绝策略
        /**
         * 4种
         * ThreadPoolExecutor类有几个内部实现类来处理这类情况：
         - AbortPolicy 丢弃任务，抛RejectedExecutionException
         - CallerRunsPolicy 由该线程调用线程运行。直接调用Runnable的run方法运行。
         - DiscardPolicy  抛弃策略，直接丢弃这个新提交的任务
         - DiscardOldestPolicy 抛弃旧任务策略，从队列中踢出最先进入队列（最后一个执行）的任务
         * 实现RejectedExecutionHandler接口，可自定义处理器
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        log.info("{} set ThreadPoolTaskExecutor completed.", ThreadPoolConfig.class.toString());
        return executor;
    }
}

