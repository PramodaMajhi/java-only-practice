package LowLevelDesign.RateLimiter;
// Refer: https://www.youtube.com/watch?v=yM4XxpdyJnM
public interface RateLimiter {
    boolean grantAccess();
}
