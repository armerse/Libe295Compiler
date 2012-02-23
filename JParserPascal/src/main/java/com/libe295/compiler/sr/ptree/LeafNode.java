package com.libe295.compiler.sr.ptree;
/****
 *
 * LeafNode extends TreeNode by adding an Object value field, but no subtree
 * references.
 *
 */
public class LeafNode extends TreeNode {

    /**
     * Construct with the given id and value.
     */
    public LeafNode(int id, Object value) {
        super(id);
        this.value = value;
    }

    /**
     * Return the string representation of this leaf, which starts with the
     * String value of its ID.  If the value field of this leaf is not null,
     * then the return value has appneded a colon, followed by the toString of
     * the value.
     */
    public String toString(int level) {
        return symPrint(id) +
	    (value == null ? "" :  (": " + value.toString()));
    }

    /** The generic value of this node, used for identifier names and literal
     * values. */
    public Object value;

}
