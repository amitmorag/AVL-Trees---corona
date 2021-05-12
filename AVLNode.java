package coronatree;

public class AVLNode {
    Person data;        // The data in the node
    AVLNode parent;        // The parent
    AVLNode left;       // Left child
    AVLNode right;      // Right child
    int height;        // Height

    /**
     * A standard constructor, sets all pointers to null.
     *
     * @param p - the data of the node.
     */
    AVLNode(Person p) {
        //your code comes here
        this.data = p;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    /**
     * A standard constructor
     *
     * @param p      - the data of the node.
     * @param lt     - the left child.
     * @param rt     - the right child.
     * @param parent - the parent.
     */
    AVLNode(Person p, AVLNode lt, AVLNode rt, AVLNode parent) {
        //your code comes here
        this.data = p;
        this.parent = parent;
        this.left = lt;
        this.right = rt;
        height = Math.max(getLeftHeight(), getRightHeight()) + 1;
    }

    public int bf() {
        return getLeftHeight() - getRightHeight();
    }

    public int getRightHeight() {
        if (this.right == null) return -1;
        return right.height;
    }

    public int getLeftHeight() {
        if (this.left == null) return -1;
        return left.height;
    }


    public String toString() {
        return this.data.toString();
    }

}
