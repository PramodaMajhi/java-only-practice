/**
 * write a function, shorteshpath, that takes in an array edges for an undirected graph.
 *  and two nodes (nodeA, nodeB). The function should return the length of the shortest path
 * between A and B. consider the length as a number of edges in the path, not the number of nodes
 * if there is no path between nodeA and nodeB, then return -1;
 * 
 * Approach: we need to use breadth first seach because its very optimal for this problem.
 * If in case we think of depth first search(stack) its go-on deep and deep unless it hits the end.
 */

const shortestPath = (edges, nodeA, nodeB) => {

    // convert the graph of array into adjacency list.
    const graph = buildGraph(edges);
    const queue = [[nodeA, 0]]; // intialize queue with starting path
    const visited = new Set([nodeA]); // initialize set with constructor
    //  as first node because we intialized our queue with starting node
    while (queue.length > 0) { // DPS only iterative no recursion
        // unpack queue
        const [node, distance] = queue.shift(); // removes first element from array 
        if (node == nodeB) return distance;

        for (const neghbor of graph[node]) {
            if (!visited.has(neghbor)) {
                visited.add(neghbor);
                queue.push([neghbor, distance + 1])
            }
        }
    }
    return -1; // we searched through the entire graph could not find the path
}

const buildGraph = (edges) => {
    const graph = {}
    for (const edge of edges) {
        //upack it
        const [a, b] = edge;
        if (!(a in graph)) graph[a] = [];
        if (!(b in graph)) graph[b] = [];
        graph[a].push(b);
        graph[b].push(a);
    }
    return graph;
}

// const edges = [
//     ['w', 'x'],
//     ['x', 'y'],
//     ['z', 'y'],
//     ['z', 'v'],
//     ['w', 'v']
//   ]; // 2
const edges = [
    ['a', 'c'],
    ['a', 'b'],
    ['c', 'b'],
    ['c', 'd'],
    ['b', 'd'],
    ['e', 'd'],
    ['g', 'f']
]; //-1

const path = shortestPath(edges, 'b', 'g'); // -> 1
console.log(path);

