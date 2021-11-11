/**
 * 57. Insert Interval
 * 
You are given an array of non-overlapping intervals 
where intervals[i] = [starti, endi] represent the start and the 
end of the ith interval and intervals is sorted in ascending order by starti. 
You are also given an interval newInterval = [start, end] that represents the 
start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending 
order by starti and intervals still does not have any overlapping intervals 
(merge overlapping intervals if necessary).
Return intervals after the insertion.
Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
 */

const insertInterval = (intervals, newInterval) => {

    if (intervals.length === 0) return [newInterval];
    let newIntervals = intervals;
    newIntervals.push(newInterval);
    let sortedIntervals = intervals.sort((a,b) => a[0] - b[0]);
    let combined = [sortedIntervals[0]];
    for (let i = 1; i < sortedIntervals.length; i++) {
        let currentInterval = sortedIntervals[i];
        let lastInterval = combined[combined.length - 1];
        const [currStart, currEnd] = currentInterval;
        const [lastStart, lastEnd] = lastInterval;
        if (currStart <= lastEnd) {
            if (currEnd > lastEnd) {
                lastInterval[1] = currEnd;
            }
        } else {
            combined.push(currentInterval);
        }
    }
    return combined;

}

const insertInterval2 = (intervals, newInterval) => {
    let combined = [];
    // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
                        // [2,5] 
    // Output: [[1,5],[6,9]]
    for(let currInterval  of intervals) {
        if(currInterval[1] < newInterval[0]) {
            combined.push(currInterval);
        } else if(newInterval[1] < currInterval[0]) {
            combined.push(newInterval);
            newInterval = currInterval;
        }else {
            newInterval[0] = Math.min(newInterval[0],currInterval[0]);
            newInterval[1] = Math.max(newInterval[1],currInterval[1]);

        }
    }
    combined.push(newInterval);
    return combined;
}

// let intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]; 
//[[1, 3], [6, 9]], newInterval = [2, 5];
//let newInterval = [4,8];
// Output: [[1,5],[6,9]]
let intervals = [[1,3],[6,9]], newInterval = [2,5]
console.log(
//insertInterval(intervals, newInterval),
insertInterval2(intervals, newInterval)
);