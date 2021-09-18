/**
 * Write a function, undirectedPath, that takes in array of edges
 * for an undirected graph an two nodes(nodeA, nodeB). The function should return a boolean 
 * indicating whether or not there exists a path between nodeA and nodeB.
 * 
 * Complexity:
 * n = # nodes
 * e = # edges
 * Time: O(e)
 * Space: O(n) 
 * 
 * lets implement this using depth first search because its easy for to recurse through
 */

undirectedPath = (edges, src, dist) => {
    const graph = buildGraph(edges);
    console.log(graph);
    return hasPath(graph, src, dist, new Set());
}
const hasPath = (graph, src, dist, visited) => {
    // Set to keep track of whether we visited or not 
    // if we visited then don't revisit again.
    if (src == dist) 
        return true;
    if (visited.has(src))
        return false;
        visited.add(src);
    for (const neighbor of graph[src]) { // another base when hashmap is empty
        if (hasPath(graph, neighbor, dist, visited) == true) {
            return true;
        }
    }
    return false;
}
/**
 * 
 * @param {*} edges 
 * @returns 
 * This a hashmap where key is node and array of edges
 * structure to work on graph.
 */
const buildGraph = (edges) => {
    const graph = {};
    for (const edge of edges) {
        const [a, b] = edge;
        if (!(a in graph)) graph[a] = [];
        if (!(b in graph)) graph[b] = [];
        graph[a].push(b);
        graph[b].push(a);
    }
    return graph;
}

const edges = [
    ['i', 'j'],
    ['k', 'i'],
    ['m', 'k'],
    ['k', 'l'],
    ['o', 'n']
];

const haspath = undirectedPath(edges, 'j', 'm'); // -> true

console.log(haspath);