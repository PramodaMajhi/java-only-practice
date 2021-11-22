/**
 * Given an array of intervals where intervals[i] = [starti, endi], 
 * merge all overlapping intervals, and return an array of the non-overlapping intervals 
 * that cover all the intervals in the input.
 * 
 
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * @param {*} intervals 
 */

const mergeIntervals = (intervals) => {
    let sortedIntervals = intervals.sort((a, b) => a[0] - b[0]);
    //[[0,4],[1,4]];
    let combined = [sortedIntervals[0]];
    for (let i = 1; i < sortedIntervals.length; i++) {
        let currentInterval = sortedIntervals[i];
        let prevInterval = combined[combined.length - 1];
        const [lastStart, lastEnd] = prevInterval;
        const [currentStart, currentEnd] = currentInterval
        if (currentStart <= lastEnd) {
            if (currentEnd > lastEnd) {
                prevInterval[1] = currentEnd;
            }
        } else {
            combined.push(currentInterval);
        }
    }
    return combined;
}
// let intervals = [[1, 4], [4, 5]];
let intervals = [[1, 4], [0, 4]];//[[1,3],[2,6],[8,10],[15,18]];
console.log(mergeIntervals(intervals))