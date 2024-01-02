/**
 * 
 * @param {*} intervals 
 * combine intervals
Write a function, combineIntervals, that takes in an array of intervals as an argument. 
Each interval is an array containing a pair of numbers representing a start and end time. 
Your function should combine overlapping intervals and return an array containing the combined intervals.

For example:

Given two intervals:

[1, 4] and [3, 7]

The intervals overlap and
should be combined into:

[1, 7]
 * 
 */

const combineIntervals = (intervals) => {

 // let temp = intervals.slice(0);
  
 let sortedIntervals = intervals.sort((intervalA , intervalB) => intervalA[0] - intervalB[0]);
 //console.log(sortedIntervals);
   
   let combined = [sortedIntervals[0]];
 //   console.log(sortedIntervals.slice(1))
   for(let i = 1 ; i < sortedIntervals.length; i ++) {
     let currentInterval = sortedIntervals[i];
     let lastInterval = combined[combined.length -1];
     
     const [lastStart, lastEnd ] = lastInterval; 
     const  [currentStart, currentEnd ] = currentInterval;
     
     if(currentStart <= lastEnd) {
       
        if(currentEnd  > lastEnd ) {
          lastInterval[1] = currentEnd;
        }
        
     } else {
       combined.push(currentInterval)
     }
     
   }
  
 return combined;
   
}
let intervals = [[1,3],[2,6],[8,10],[15,18]];
//console.log(intervals);

let display = combineIntervals(intervals);
for (const interval of display) {
    console.log(interval);
}
// console.log(intervals);
// console.log(intervals);