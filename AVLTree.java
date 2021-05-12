package coronatree;

public class AVLTree {

    AVLNode root;    // The tree root.
    int size;        // The size of the tree.

    /**
     * Construct an empty tree.
     */
    public AVLTree() {
        //your code comes here
        this.root = new AVLNode(null);
        this.size = 0;
    }

    /**
     * Returns the size of the tree.
     *
     * @return the size of the tree.
     */
    public int size() {
        //your code comes here
        return size;
    }

    /**
     * Returns the height of the tree.
     * Returns -1 if the tree is empty.
     *
     * @return the height of the tree.
     */
    public int height() {
        //your code comes here
        if (size == 0) return -1;
        return this.root.height;
    }

    /**
     * Inserts into the tree; You may assume that every person has a unique ID number.
     * That is, no person will appear twice.
     *
     * @param p - the person to insert.
     */

    public void insert(Person p) {
        this.size++;
        AVLNode index = root;
        if (size == 1) {//the tree is empty
            root = new AVLNode(p, null, null, null);
            return;
        }
        //percolate down if possible
        while ((p.id < index.data.id && index.left != null) || (p.id > index.data.id && index.right != null)) {
            if (index.data.id > p.id)
                index = index.left;
            else
                index = index.right;
        }
        AVLNode node = new AVLNode(p, null, null, index);//index is the parent of node
        if (p.id < index.data.id) {//check where to put the new child
            index.left = node;
        } else
            index.right = node;
        for (AVLNode j = node.parent; j != null; j = j.parent) {//go up and fix the heights
            if (Math.abs(j.bf()) > 1)
                rebalance(j);
            else
                reCalculateHeight(j);
        }
        return;
    }

    public void reCalculateHeight(AVLNode n) {
        n.height = Math.max(n.getLeftHeight(), n.getRightHeight()) + 1;
    }

    public void updateAllH(AVLNode n) {
        while (n != null) {
            reCalculateHeight(n);
            n = n.parent;
        }
    }

    public void rebalance(AVLNode n) {
        if (n.bf() > 1) {
            if (n.left.bf() < 0)
                leftRot(n.left);//left right case
            rightRot(n);//left left case
        } else {
            if (n.right.bf() > 0)
                rightRot(n.right);//right left case
            leftRot(n);//right right case
        }
    }

    public void leftRot(AVLNode x) {
        AVLNode z = x.right;
        AVLNode t23 = z.left;
        x.right = t23;
        if (z.left != null) t23.parent = x;// if t23 exists
        z.parent = x.parent;
        if (x.parent != null) {
            if (x == x.parent.left)//x is left child
                x.parent.left = z;
            if (x == x.parent.right)//x is right child
                x.parent.right = z;
        } else root = z;
        z.left = x;
        x.parent = z;
        reCalculateHeight(x);
        reCalculateHeight(z);
        updateAllH(x.parent);
    }

    public void rightRot(AVLNode x) {
        AVLNode z = x.left;
        AVLNode t23 = z.right;
        x.left = t23;
        if (z.right != null) t23.parent = x;
        z.parent = x.parent;
        if (x.parent != null) {
            if (x == x.parent.left)
                x.parent.left = z;//x is left child
            if (x == x.parent.right)
                x.parent.right = z;//x is right child
        } else root = z;
        z.right = x;
        x.parent = z;
        reCalculateHeight(x);
        reCalculateHeight(z);
        updateAllH(x.parent);
    }

    public boolean IsLeftLeft() {
        if (this.root.left == null)
            return false;
        return true;
    }


    /**
     * Search for a person in the tree.
     *
     * @param p the person to search for.
     * @return true iff 'p' is an element in the tree.
     */
    public boolean search(Person p) {
        //your code comes here
        AVLNode index = root;
        while (index.right != null || index.left != null) {
            if (index.data.id == p.id) return true;
            if (index.data.id > p.id)
                index = index.left;
            if (index.data.id < p.id)
                index = index.right;
        }
        return false;
    }

    /**
     * Traverse the contents of this tree in an 'inorder' manner and return and array
     * containing the traversal of the tree.
     *
     * @return a sorted array of the tree's content.
     */

    public Person[] inorder() {
        //your code comes here
        Person[] arr = new Person[size];
        AVLNode start = root;
        i = 0;
        inorder(start, arr);
        return arr;
    }

    static int i = 0;

    public void inorder(AVLNode t, Person[] arr) {
        if (t.left != null) inorder(t.left, arr);
        arr[i++] = t.data;
        if (t.right != null) inorder(t.right, arr);
    }


}
