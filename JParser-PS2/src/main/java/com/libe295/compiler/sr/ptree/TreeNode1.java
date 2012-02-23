package com.libe295.compiler.sr.ptree;
/****
 *
 * TreeNode1 extends TreeNode by adding one child component, which is a
 * reference to another TreeNode.  Hence, TreeNode1 is used to represent unary
 * syntactic constructs in a parse tree.
 *
 */
public class TreeNode1 extends TreeNode {

    /**
     * Construct this with the given id and child TreeNode reference.
     */
    public TreeNode1(int id, TreeNode child) {
        super(id);
        this.child = child;
    }

    /**
     * Return the String representation of this subtree, which is the String
     * value of its ID, followed on the next indented line by the recursive
     * toString of its child.  See the documentation for <a href=
     * "TreeNode.html#toString()"> TreeNode.toString() </a> for a general
     * description the way trees are represented as strings.
     */
    public String toString(int level) {
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "  ";
        }
        return symPrint(id) + "\n" +
            indent + "  " + (child == null ? "null" : child.toString(level+1)) + "\n";
    }

    /** Reference to the single child of this node. */
    public TreeNode child;

}
