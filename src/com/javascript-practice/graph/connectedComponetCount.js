/**
 * Write a function, connectedComponentsCount, thats takes in adjacency list of an
 * undirected graph. The function should return the number of 
 * connected components within the graph.
 * connectedComponentsCount({
  0: [8, 1, 5],
  1: [0],
  5: [0, 8],
  8: [0, 5],
  2: [3, 4],
  3: [2, 4],
  4: [3, 2]
}); // -> 2
 * 
 */



const connectedComponentsCount = (graph) => {
    const visited = new Set();
    let count = 0;
    for (let node in graph) {
        if (explore(graph, node, visited) == true) {
            count += 1;
        }
    }
    return count;

};

const explore = (graph, current, visited) => {

    if (visited.has(String(current))) return false;
        visited.add(String(current));
    /** 
        javascript always store key in string. 
        even its holds numeric array as value
    **/
    for (let neighbor of graph[current]) {
        explore(graph, neighbor, visited);
    }
    return true;
}



let graph = {
    3: [],
    4: [6],
    6: [4, 5, 7, 8],
    8: [6],
    7: [6],
    5: [6],
    1: [2],
    2: [1]
}
// console.log(connectedComponentsCount(graph));
// const count = connectedComponentsCount({
//     3: [],
//     4: [6],
//     6: [4, 5, 7, 8],
//     8: [6],
//     7: [6],
//     5: [6],
//     1: [2],
//     2: [1]
//   }); // -> 3
//   console.log(count);

const count = connectedComponentsCount({
    1: [2],
    2: [1, 8],
    6: [7],
    9: [8],
    7: [6, 8],
    8: [9, 7, 2]
}); // -> 1
console.log(count);