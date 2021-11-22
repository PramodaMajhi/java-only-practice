/**
616. Add Bold Tag in String
You are given a string s and an array of strings words. 
You should add a closed pair of bold tag <b> and </b> to wrap the substrings
in s that exist in words. If two such substrings overlap, 
you should wrap them together with only one pair of closed 
bold-tag. If two substrings wrapped by bold tags are consecutive, 
you should combine them. Return s after adding the bold tags.

Example 1:
Input: s = "abcxyz123", words = ["abc","123"]
Output: "<b>abc</b>xyz<b>123</b>"
*/
/**
 * The worst case: s = "aaa...aaaa", dict = ["a", "aa", ... "aaa...aaaa"]

indexOf method takes O(N * w_i) time for the worst case for each w_i, where N is len(s), and w_i is length of each word in dict.
merging intervals takes time O(N^2logN), space O(N^2), since in the worst case there can be O(N^2) intervals
Overall complexity time O(N*sum(w_i) + N^2logN), space O(N^2) for worst-case.
 * @param {*} str 
 * @param {*} words 
 * @returns 
 */

const addBoldTag = (str, words) => {
    let intervals = [];
    for (let w of words) {
        let index = str.indexOf(w, 0);
        while (index !== -1) {
            intervals.push([index, index + w.length])
            index = str.indexOf(w, index + 1);
        }
    }

    let sortedIntervals = intervals.sort((a, b) => a - b)
    // console.log(intervals);
    let combinedIntervals = [sortedIntervals[0]];
    for (let first = 1; first < sortedIntervals.length; first++) {
        let currentInterval = sortedIntervals[first];
        let lastInterval = combinedIntervals[combinedIntervals.length - 1];
        const [lastStart, lastEnd] = lastInterval;
        const [currentStart, currentEnd] = currentInterval;
        // console.log(`currentStart ${currentStart} , 
        //             currentEnd ${currentEnd}, 
        //             lastStart ${lastStart} 
        //             lastEnd ${lastEnd}`
        // );
        //  intervals = [[1,3],[2,6],[8,10],[15,18]]
        if (currentStart <= lastEnd) {
            if (currentEnd > lastEnd) {
                lastInterval[1] = currentEnd;
            }
        } else {
            combinedIntervals.push(currentInterval);
        }
    }

    let result = [];
    const bstartTag = "<b>";
    const bEndTag = "</b>";
    let prev = 0;
    for (let i = 0; i < combinedIntervals.length; i++) {
        let [startInterval, endInterval] = combinedIntervals[i];
        result.push(str.substring(prev, startInterval));
        result.push(bstartTag);
        result.push(str.substring(startInterval, endInterval));
        result.push(bEndTag);
        prev = endInterval;
    }
    if (prev < str.length) {
        result.push(str.substring(prev));
    }
    return result.join('');

}

const addBoldTag1 = (s, dict) => {
    let marked = new Array(s.length).fill(false);
    for (let word of dict) {
        let start = s.indexOf(word);
        while (start != -1) {
            marked.fill(true, start, start + word.length);
            start = s.indexOf(word, start + 1);
        }
    }
    let result = marked[0] ? "<b>" : "";
    for (let i = 0; i < marked.length; i++) {
        result += s.charAt(i);
        if (!marked[i] && marked[i + 1])
            result += "<b>";
        else if (marked[i] && !marked[i + 1])
            result += "</b>";
    }
    return result;

}

// let s = "abcxyz123", words = ["abc", "123"];
let s = "aaabbcc", words = ["aaa", "aab", "bc"]
console.log(
    //  addBoldTag(s, words),
    addBoldTag1(s, words)
);