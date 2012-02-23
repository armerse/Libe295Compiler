package com.libe295.compiler.sr.ptree;
/****
 *
 * TreeNode2 extends TreeNode by adding two child components, which are
 * references other TreeNodes.  Hence, TreeNode2 is used to represent binary
 * syntactic constructs in a parse tree.
 *
 */
public class TreeNode2 extends TreeNode {

    /**
     * Construct this with the given id and child TreeNode references.
     */
    public TreeNode2(int id, TreeNode child1, TreeNode child2) {
        super(id);
        this.child1 = child1;
        this.child2 = child2;
    }
 
    /**
     * Return the String representation of this subtree, which is the String
     * value of its ID, followed on the next two indented lines by the
     * recursive toString of its two children.  See the documentation for <a
     * href= "TreeNode.html#toString()"> TreeNode.toString() </a> for a general
     * description the way trees are represented as strings.
     */
    public String toString(int level) {
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "  ";
        }
        return symPrint(id) + "\n" +
            indent + "  " + (child1 == null ? "null" : child1.toString(level+1)) + "\n" +
            indent + "  " + (child2 == null ? "null" : child2.toString(level+1));
    }

    /** Reference to the left child of this node. */
    public TreeNode child1;

    /** Reference to the right child of this node. */
    public TreeNode child2;

}
