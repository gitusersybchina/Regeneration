package org.demo.lxx.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * 线程池学习，简单示例
 * 以下内容参考，博主总结非常到位：https://www.jianshu.com/p/7726c70cdc40
 * <p>
 * 创建线程池就是为了解决处理器单元内多个线程执行的问题，它可以显著减少处理器单元的闲置时间，增加处理器单元的吞吐能力;
 * ============================================================================================================
 * <li> 为什么使用线程池?</li>
 * <p>
 * 实际开发中有时随着需要做的任务慢慢的增多，复杂性也会变得越来越强，所以线程的个数就会一点点的往上增加，
 * 而对应的线程占用的资源也就越来越多，多个线程占用资源的释放与注销需要维护，这时候多个线程的管理就显得有尤为重要。
 * 针对这一情况，sun公司提供了线程池，对线程集合的管理工具API。
 * </p>
 * ============================================================================================================
 * <li> 线程池的优势?</li>
 * <p>
 * <li>降低系统资源消耗，通过重用已存在的线程，降低线程创建和销毁造成的消耗</li>
 * <li>提高系统响应速度，当有任务到达时，通过复用已存在的线程，无需等待新线程的创建便能立即执行</li>
 * <li>方便线程并发数的管控。因为线程若是无限制的创建，可能会导致内存占用过多而产生OOM，并且会造成cpu过度切换</li>
 * <li>提供更强大的功能，延时定时线程池</li>
 * </p>
 * ============================================================================================================
 * <li> todo 线程池的工作流程<li/>
 * <p>
 * ============================================================================================================
 * <li> 为什么使用阻塞队列?</li>
 * <p>
 * 避免无限制的创建线程而导致OOM及CPU过度切换。
 * 阻塞队列可以保证任务队列中没有任务时阻塞获取任务的线程，使得线程进入wait状态，释放cpu资源。
 * 只有当队列中有任务时才唤醒对应线程从队列中取出消息进行执行，减少CPU的性能损耗。
 * </p>
 * ============================================================================================================
 * <li> 如何配置线程池?</li>
 * <p>
 * CPU密集型：尽量使用较小的线程池，一般为CPU核心数+1。此类任务使得CPU使用率很高，若开过多的线程数，会造成CPU过度切换。
 * IO密集型：可以使用稍大的线程池，一般为2*CPU核心数。此类任务CPU使用率不高，可以让CPU在等待IO的时候有其他线程去处理别的任务，充分利用CPU。
 * 混合型：可以将任务分成IO密集型和CPU密集型任务，然后分别用不同的线程池去处理。
 * 只要分完之后两类任务的执行时间相差不大，那么就会比串行执行来的高效。
 * 如果拆分的两类任务执行时间有数据级差异，那么拆分的意义就不大了。因为最终时间取决于后执行完的任务，再加上拆分任务的开销，得不偿失。
 * </p>
 * </p>
 * ============================================================================================================
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/5/28 10:19
 *
 * <li>
 * @see java.util.concurrent.ExecutorService
 * </li>
 *
 * <li>
 * @see java.util.concurrent.Executor
 * 提供了很多方法来创建线程池
 * @see Executors#newSingleThreadExecutor()
 * @see Executors#newFixedThreadPool(int)
 * @see Executors#newCachedThreadPool()
 * @see Executors#newScheduledThreadPool(int)
 * </li>
 *
 * <p>
 * 阿里编码规约:
 * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明：Executors返回的线程池对象的弊端如下：
 * 1）FixedThreadPool和SingleThreadPool:
 *   允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
 * 2）CachedThreadPool:
 *   允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。
 * <li>
 * @see java.util.concurrent.ThreadPoolExecutor
 * 提供了不同的构造函数来创建不同的线程池，可以是我们更清楚线程池如何创建
 * @see java.util.concurrent.ThreadPoolExecutor#ThreadPoolExecutor
 * </li>
 * </p>
 */
public class ThreadPoolDemos {

    public static void main(String[] args) {

        ExecutorService executorService;
        // 创建单个线程的线程池，即线程池中每次只有一个线程工作，单线程串行执行任务
        // 使用 BlockingQueue 作为等待队列
        final ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        testExecuteAndShutdown(executorService1);

        // 创建一个线程数量固定的线程池，
        // 超过这个数量之后进来的任务，会放到等待队列中，
        // 如果有空闲线程，则在等待队列中获取，遵循先进先出原则
        // 使用 LinkedBlockingQueue 作为等待队列
        final ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        testExecuteAndShutdown(executorService2);

        // 创建一个缓存型的线程池，
        // 在核心线程达到最大值前，如果继续有任务进来就去创建新的核心线程并加入核心线程池，即使有空闲线程也不会去复用
        // 在达到最大核心线程数后，新任务进来，如果有空闲线程，则直接拿来使用，如果没有空闲线程，则新建临时线程
        // 使用 SynchronousQueue 作为等待队列，不保存任何任务，新任务加入后会创建临时线程来使用
        final ExecutorService executorService3 = Executors.newCachedThreadPool();
        testExecuteAndShutdown(executorService3);

        // 创建一个计划性的线程池，该线程池可以计划在给定的延迟，或周期性地执行
        // 在新任务到达时，如果有空闲线程就直接使用空闲现场，如果没有就创建新线程加入到线程池中
        // 使用 DelayedWorkQueue 作为等待队列，会进行一定的延迟处理，等待时间过后继续执行任务
        final ExecutorService executorService4 = Executors.newScheduledThreadPool(10);
        testExecuteAndShutdown(executorService4);

        // ali Example1
        executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("demo-schedule-pool-%d").daemon(true).build());
        testExecuteAndShutdown(executorService);
        // ali Example2
        executorService = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                new BasicThreadFactory.Builder().namingPattern("demo-pool-%d").daemon(true).build(),
                new ThreadPoolExecutor.AbortPolicy());
        testExecuteAndShutdown(executorService);
    }

    private static void testExecuteAndShutdown(ExecutorService executorService) {
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        // gracefully shutdown
        executorService.shutdown();
    }

}
