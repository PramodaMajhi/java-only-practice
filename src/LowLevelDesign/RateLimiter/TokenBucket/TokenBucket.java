package LowLevelDesign.RateLimiter.TokenBucket;

import LowLevelDesign.RateLimiter.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
// Refer: https://www.youtube.com/watch?v=TCTkkVoY3-I
public class TokenBucket implements RateLimiter {
private int bucketCapacity;
private int refreshRate;
private AtomicInteger currentCapacity;
private AtomicLong lastUpdatedTime;

public TokenBucket(int bucketCapacity, int refreshRate){
    this.bucketCapacity = bucketCapacity;
    this.refreshRate = refreshRate;
    // Creates a new AtomicInteger with the given initial value.
    currentCapacity = new AtomicInteger(bucketCapacity);
    lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
}

    @Override
    public boolean grantAccess() {
         refreshBucket();
        if(currentCapacity.get() > 0){ // Gets the current value.
            // Atomically decrements by one the current value.
            currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }
    private void refreshBucket(){
        long currentTime = System.currentTimeMillis();
        // We need to check how many more token need to be added
        // convert into seconds
        int additionalToken =  (int)(currentTime - lastUpdatedTime.get())/1000 * refreshRate;
        // should not cross bucket size.
        int currCapacity = Math.min(currentCapacity.get() + additionalToken, bucketCapacity);
       // Atomically adds the given value to the current value.
        currentCapacity.getAndSet(currCapacity);
        lastUpdatedTime.getAndSet(currentTime);
    }
}
