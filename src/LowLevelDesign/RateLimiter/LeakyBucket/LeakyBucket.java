package LowLevelDesign.RateLimiter.LeakyBucket;

import LowLevelDesign.RateLimiter.RateLimiter;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LeakyBucket implements RateLimiter {
    BlockingDeque<Integer> queue;
    LeakyBucket(int capacity){
        this.queue = new LinkedBlockingDeque<Integer>(capacity);
    }
    @Override
    public boolean grantAccess() {
        if(queue.remainingCapacity() > 0){
            queue.add(1);
            return true;
        }
        return false;
    }
}
