package labylost.engine.game;

import java.util.ArrayList;
import java.util.List;

final class Clock {

    private long tickDuration;
    private boolean pause;
    private boolean exit;
    private Thread t;
    private List<ClockTickObserver> observers;

    public Clock(long tickDuration) {
        this.tickDuration = tickDuration;
        this.observers = new ArrayList<>();
    }

    public void start() {
        if(t == null) {
            t = new Thread(this::exec);
        }
        t.start();
    }

    public void addObserver(ClockTickObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(ClockTickObserver observer) {
        this.observers.remove(observer);
    }

    private void exec()  {
        while(!exit) {
            if(!pause) {
                try {
                    Thread.sleep(tickDuration);
                } catch(InterruptedException e) {
                    continue;
                }
                observers.forEach(ClockTickObserver::onTick);
            }
        }
    }

    public void pause() {
        this.pause = true;
    }

    public void cont() {
        this.pause = false;
    }

    public void exit() {
        this.exit = true;
    }

}