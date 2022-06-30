package com.stackroute.hackerrankchallenge;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class BalancedNode {

    int name;
    long weight;
    long subTreeWeight;
    BalancedNode parent;
    Set<BalancedNode> children;

    BalancedNode(int name, long weight){
        this.name = name;
        this.weight = weight;
        this.subTreeWeight = weight;
        children = new HashSet<>();
    }

    // sets n as a child of this
    void addNeighbor(BalancedNode n){
        this.children.add(n);
    }

    // removes n from the set of children
    boolean removeFromChildren(BalancedNode n){
        return this.children.remove(n);
    }

    int numChildren(){
        return this.children.size();
    }
}

public class BalancedForest {

    //private static final Logger logger = LoggerFactory.getLogger(BalancedForest.class);

    /**
     * Main method modified to avoid timeout on Test 4 and Test 5
     *
     * public static void main(String[] args) throws IOException {
     *
     *     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     *     StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
     *     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
     *
     *     int q = Integer.parseInt(st.nextToken());
     *     for (int qItr = 0; qItr < q; qItr++) {
     *     		int n = Integer.parseInt(bufferedReader.readLine())
     *
     *     		int[] c = new int[n];
     *     		String[] cItems = bufferedReader.readLine().split(" ");
     *     		for (int i = 0; i < n; i++) {
     *     			int cItem = Integer.parseInt(cItems[i]);
     *     			c[i] = cItem;
     *     		}
     *
     *     		int[][] edges = new int[n - 1][2];
     *
     *     		for (int i = 0; i < n - 1; i++) {
     *     			String[] edgesRowItems = bufferedReader.readLine().split(" ");
     *     			for (int j = 0; j < 2; j++) {
     *     				int edgesItem = Integer.parseInt(edgesRowItems[j]);
     *     				edges[i][j] = edgesItem;
     *     			}
     *     		}
     *
     *     		long result = balancedForest(c, edges);
     *     		bufferedWriter.write(String.valueOf(result));
     *     		bufferedWriter.newLine();
     *    }
     *
     *    bufferedWriter.close();
     *    bufferedReader.close();
     * }
     */
//    public static void main(String[] args) {
//        int[] c1 = {1,2,2,1,1};
//        int[][] edges1 = {{1,2},{1,3},{3,5},{1,4}};
//        logger.info(String.valueOf(balancedForest(c1, edges1)));
//
//        int[] c2 = {1,3,5};
//        int[][] edges2 = {{1,3},{1,2}};
//        logger.info(String.valueOf(balancedForest(c2, edges2)));
//
//        int[] c3 = {15,12,8,14,13};
//        int[][] edges3 = {{1,2},{1,3},{1,4},{4,5}};
//        logger.info(String.valueOf(balancedForest(c3, edges3)));
//
//        int[] c4 = {12,10,8,12,14,12};
//        int[][] edges4 = {{1,2},{1,3},{1,4},{2,5},{4,6}};
//        logger.info(String.valueOf(balancedForest(c4, edges4)));
//    }

    // Complete the balancedForest function below.
    static long balancedForest(int[] c, int[][] edges) {

        BalancedNode[] nodes = new BalancedNode[c.length];
        for(int i = 0; i < c.length; i++){
            nodes[i] = new BalancedNode(i, (long)c[i]);
        }

        for(int j = 0; j < edges.length; j++){
            int vertice0 = edges[j][0] - 1;
            int vertice1 = edges[j][1] - 1;
            nodes[vertice0].addNeighbor(nodes[vertice1]);
            nodes[vertice1].addNeighbor(nodes[vertice0]);
        }

        BalancedNode root = nodes[0];
        long totalWeight = setSubTreeWeights(root);

        long minValue = tryBranches(root, root, totalWeight, totalWeight);
        if(minValue == totalWeight){
            minValue = -1L;
        }

        return minValue;
    }

    static long setSubTreeWeights(BalancedNode root){

        for(BalancedNode node : root.children){
            node.parent = root;
            node.removeFromChildren(root);
            long childrenSubWeight = setSubTreeWeights(node);
            root.subTreeWeight += childrenSubWeight;
        }

        return root.subTreeWeight;
    }

    static long tryBranches(BalancedNode root, BalancedNode branch, long totalWeight, long minValue){

        // weight of the subtree rooted at branch
        long subWeight = branch.subTreeWeight;
        // weight of the subtree obtained by removing branch & its descendants from the tree
        long diffWeight = totalWeight - subWeight;

        if(subWeight == diffWeight){
            minValue = subWeight;
        } else{
            BalancedNode smallRoot = branch;
            long smallWeight = subWeight;
            if (diffWeight < subWeight && diffWeight != 0L){
                smallRoot = root;
                smallWeight = diffWeight;
            }

            long bestWeight = 3*smallWeight - totalWeight;

            if(bestWeight >= 0 && bestWeight < minValue){
                // if the smaller subtree was rooted at branch, remove branch and its descendants
                // and then search for an edge in the resulting subtree
                if(smallRoot == branch){
                    branch.subTreeWeight = 0;
                    BalancedNode parent = branch.parent;
                    while(parent != null){
                        parent.subTreeWeight -= subWeight;
                        parent = parent.parent;
                    }

                    // search for the solution
                    if(findWeight(root, subWeight, diffWeight)){
                        minValue = bestWeight;
                    }

                    // reset the tree weights we changed back to their original values.
                    branch.subTreeWeight = subWeight;
                    parent = branch.parent;
                    while(parent != null){
                        parent.subTreeWeight += subWeight;
                        parent = parent.parent;
                    }

                }else{
                    // the smaller subtree was rooted at root, so check the subtree rooted at branch
                    if(findWeight(branch, diffWeight, subWeight)){
                        minValue = bestWeight;
                    }
                }
            }
        }

        // recurse on children
        Iterator<BalancedNode> iterator = branch.children.iterator();
        while(iterator.hasNext()){
            BalancedNode node = iterator.next();
            long bestWeight = tryBranches(root, node, totalWeight, minValue);
            if(bestWeight < minValue){
                minValue = bestWeight;
            }
        }

        return minValue;
    }

    static boolean findWeight(BalancedNode root, long weight, long totalWeight){
        boolean weightFound = false;
        long rootWeight = root.subTreeWeight;
        long remWeight = totalWeight - root.subTreeWeight;

        if(rootWeight == weight || remWeight == weight){
            return true;
        } else if (rootWeight > weight || remWeight < weight){
            Iterator<BalancedNode> childIter = root.children.iterator();
            while(childIter.hasNext() && !weightFound){
                BalancedNode node = childIter.next();
                weightFound = weightFound || findWeight(node, weight, totalWeight);
            }
        }

        return weightFound;
    }
}