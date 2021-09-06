/**
 * Largest component
 * Write a function, largestComponent, that makes in the adjacency list of an undirected graph.
 * The function should return the size of the largest connected component in the graph.
 * complexity : o(e)
 * space : o(n)
 * Appraoch here is depth first search
 * 
 */

const largestComponent = (graph) => {
    const visited = new Set();
    let longest = 0;
    for (let node in graph) {
        const size  = explore(graph, node, visited);
        if(size > longest) {
            longest = size;
        }
    }
    return longest;
}

const explore = (graph, node, visited) => {
    if(visited.has(node)) return 0;
    visited.add(node);
    let size = 1;
    for (let neighbor of graph[node]) {
        size += explore(graph, neighbor, visited)
    }
    return size;
    
} 

// const largest  = largestComponent({
//     0: ['8', '1', '5'],
//     1: ['0'],
//     5: ['0', '8'],
//     8: ['0', '5'],
//     2: ['3', '4'],
//     3: ['2', '4'],
//     4: ['3', '2']
//   }); // -> 4

  const largest  =  largestComponent({
    1: ['2'],
    2: ['1','8'],
    6: ['7'],
    9: ['8'],
    7: ['6', '8'],
    8: ['9', '7', '2']
  }); // -> 6

  console.log(largest);