package LowLevelDesign.RateLimiter.SlidingWindow;

import LowLevelDesign.RateLimiter.TokenBucket.TokenBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer, SlidingWindow> bucket;
    public UserBucketCreator(int id){
        bucket = new HashMap<>();
        bucket.put(id, new SlidingWindow(1, 5));
    }

    public void accessApplication(int id) {
        if(bucket.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> 429 too many request");
        }
    }
}
