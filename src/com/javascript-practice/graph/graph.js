/**
 * Depth first search uses stack.
 * @param {*} graph 
 * @param {*} source 
 */

const depthFirstPrint = (graph, source) => {
  //  console.log(source);
    const stack = [source];
    while(stack.length > 0) {
        const current  = stack.pop();
        console.log(current);
        for (const neighbor of graph[current]) {
            stack.push(neighbor);
        }
    }
}

// Depth first using recurssion
depthFirstRecursion = (graph, source) => {
    console.log(source);
    for (const neigbhor of graph[source]) {
        depthFirstRecursion(graph,neigbhor);
    }
}

const graph = {
    a: ['c','b'],
    b: ['d'],
    c: ['e'],
    d: ['f'],
    e: [],
    f: []
}

// depthFirstPrint(graph, 'a'); // abdfce
// 
console.log("-------");
const graph1 = {
    a: ['b','c'],
    b: ['d'],
    c: ['e'],
    d: ['f'],
    e: [],
    f: [] // zero recursion because empty array
}
// depthFirstRecursion(graph1,'a');

// Breadth first search uses queue
breadthFirstPrint = (graph, source) => {
    const queue = [source];
    while(queue.length > 0 ) {
        let current = queue.shift();
        console.log(current);
        for(let neigbhor of graph[current]) {
            queue.push(neigbhor);
        }
    }
}

// breadthFirstPrint(graph, 'a'); // acbedf 
/**
 * has path 
 * write a function, hasPath, takes in an object representing the adjacency list
 * list of a directed directed acyclic graph and two nodes
 * (src,dist). The fuction should return a boolean indicating whether or not there exits
 * a directed path between the source and distation nodes.
 */
const newGraph = {
    f: ['g','i'],
    g: ['h'],
    h: [],
    i: ['g','k'],
    j: ['i'],
    k: []
}
// This can be solved using depth first search.
const hasPath = (graph, src, dist) => {
    if(src == dist) {
        return true;
    }
    for (const neighbor of graph[src]) {
        if(hasPath(graph,neighbor,dist) == true) {
            return true;
        }
    }
    return false;
};
// const path = hasPath(newGraph,'g','o');
 // console.log(path);

// let try same problem using breadth first search.. there is no way we can solve using recursion
// Only iterative way to solution breadth first search.
// Breadth first search uses queue.

const hasPathBF = (graph, src, dist) => {
    const queue = [src];
    while(queue.length > 0) {
        const current = queue.shift();
        if(current === dist) {
            return true;
        }
        for (const neighbor of graph[current]) {
            queue.push(neighbor);
        }
     }
     return false;
}

const path = hasPathBF(newGraph,'f','i');
console.log(path);