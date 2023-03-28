package zad2;

import java.util.concurrent.atomic.AtomicInteger;

public class StringTask implements Runnable
{
    private volatile TaskState state;
    private Thread th;
    private volatile String concat;
    private volatile String variable;
    private volatile AtomicInteger atomicInteger;

    public enum TaskState
    {
        CREATED,RUNNING,READY,ABORTED
    }
    public StringTask()
    {
        state = TaskState.CREATED;
        this.concat = "";
    }

    public StringTask(int amp)
    {
       this();
       atomicInteger = new AtomicInteger(amp);
    }

    public StringTask(String variable, int amp)
    {
        this(amp);
        this.variable = variable;
    }

    @Override
    public void run()
    {
        state = TaskState.RUNNING;
        if (state != TaskState.ABORTED)
        {
            while (atomicInteger.get() != 0 && state != TaskState.ABORTED)
            {
                concat += variable;
                atomicInteger.decrementAndGet();
            }
        }
        if (state != TaskState.ABORTED)
            state = TaskState.READY;
    }

    public String getResult()
    {
        return this.concat;
    }

    public TaskState getState()
    {
        return this.state;
    }

    public void start()
    {
        th = new Thread(this);
        state = TaskState.RUNNING;
        th.start();
    }

    public void abort()
    {
        state = TaskState.ABORTED;
        if (!Thread.currentThread().isInterrupted())
            Thread.currentThread().interrupt();
    }

    public boolean isDone()
    {
        boolean done = false;
        if (state == TaskState.READY || state == TaskState.ABORTED)
            done = true;
        return done;
    }


}
