/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it179.pa5;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
/**
 *
 * @author bsdwork
 */
public class IT179PA5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node<Integer> n0 = new Node<Integer>(0);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n4 = new Node<Integer>(4);
        Node<Integer> n5 = new Node<Integer>(5);
        Node<Integer> n6 = new Node<Integer>(6);
        Node<Integer> n7 = new Node<Integer>(7);
        Node<Integer> n8 = new Node<Integer>(8);
        Node<Integer> n9 = new Node<Integer>(9);
        Node<Integer> n10 = new Node<Integer>(10);
        Node<Integer> n11 = new Node<Integer>(11);
        Node<Integer> n12 = new Node<Integer>(12);
        BinaryTree<Integer> bt = new BinaryTree<Integer> (n7);
        
        
        n7.left = n1;
        n7.right = n11;
        n1.left = n0;
        n1.right = n3;
        n3.left = n2;
        n3.right = n5;
        n5.left = n4;
        n5.right = n6; 
        n11.left = n9;
        n11.right = n12;
        n9.left = n8;
        n9.right = n10;
        
        System.out.println("Traversing the tree via preorder:");
        bt.preOrder(bt.root);
        System.out.println("\n");
        System.out.println("Traversing the tree via inorder:");
        bt.inOrder(bt.root);
        System.out.println("\n");
        System.out.println("Traversing the tree via postorder:");
        bt.postOrder(bt.root);
        System.out.println("\n");
        
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer> ();
        bst.add(n1.data);
        bst.add(n2.data);
        bst.add(n3.data);
        bst.add(n4.data);
        bst.add(n5.data);
        bst.add(n6.data);
        bst.add(n7.data);
        bst.add(n8.data);
        bst.add(n9.data);
        bst.add(n10.data);
        bst.add(n11.data);
        bst.add(n12.data);
        
        bst.contains(8);
        
        bst.remove(2);
        bst.remove(4);
        bst.remove(6);
        bst.remove(8);
        System.out.println("New order removing 2,4,6,and 8:");
        System.out.println(bst.toString());
        
        
    }
    
    public static class BinaryTree<E> implements Serializable {
    /*</listing>*/
    // Data Field
    /** The root of the binary tree */
        protected Node<E> root;

    /** Construct an empty BinaryTree */
        public BinaryTree() {
            root = null;
        }

    /**
     * Construct a BinaryTree with a specified root.
     * Should only be used by subclasses.
     * @param root The node that is the root of the tree.
     */
        protected BinaryTree(Node<E> root) {
            this.root = root;
        }

    /**
     * Constructs a new binary tree with data in its root,leftTree
     * as its left subtree and rightTree as its right subtree.
     */
        public BinaryTree(E data, BinaryTree<E> leftTree,BinaryTree<E> rightTree) {
           root = new Node<E>(data);
           if (leftTree != null) {
                root.left = leftTree.root;
            } else {
                root.left = null;
            }
            if (rightTree != null) {
                root.right = rightTree.root;
            } else {
                root.right = null;
            }
        }

    /**
     * Return the left subtree.
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
        public BinaryTree<E> getLeftSubtree() {
            if (root != null && root.left != null) {
                return new BinaryTree<E>(root.left);
            } else {
               return null;
            }
        }

    /**
     * Return the right sub-tree
     * @return the right sub-tree or
     *         null if either the root or the
     *         right subtree is null.
     */
        public BinaryTree<E> getRightSubtree() {
            if (root != null && root.right != null) {
                return new BinaryTree<E>(root.right);
            } else {
                return null;
            }
        }

    /**
     * Return the data field of the root
     * @return the data field of the root
     *         or null if the root is null
     */
        public E getData() {
           if (root != null) {
              return root.data;
            } else {
               return null;
            }
        }

    /**
     * Determine whether this tree is a leaf.
     * @return true if the root has no children
     */
        public boolean isLeaf() {
            return (root == null || (root.left == null && root.right == null));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            preOrderTraverse(root, 1, sb);
            return sb.toString();
        }

    /**
     * Perform a preorder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
        private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
            for (int i = 1; i < depth; i++) {
                sb.append("  ");
            }
            if (node == null) {
               sb.append("null\n");
            } else {
                sb.append(node.toString());
                sb.append("\n");
                preOrderTraverse(node.left, depth + 1, sb);
                preOrderTraverse(node.right, depth + 1, sb);
            }
        }
        

    /*<listing chapter="6" number="2">*/
    /**
     * Method to read a binary tree.
     * @pre The input consists of a preorder traversal
     *      of the binary tree. The line "null" indicates a null tree.
     * @param bR The input file
     * @return The binary tree
     * @throws IOException If there is an input error
     */
        public BinaryTree<String> readBinaryTree(BufferedReader bR)throws IOException {
        // Read a line and trim leading and trailing spaces.
            String data = bR.readLine().trim();
            if (data.equals("null")) {
                return null;
            } else {
                BinaryTree<String> leftTree = readBinaryTree(bR);
                BinaryTree<String> rightTree = readBinaryTree(bR);
                return new BinaryTree<String>(data, leftTree, rightTree);
            }
        }
        
        public void inOrder(Node root){
            if(root != null){
                inOrder(root.left);
                System.out.printf("%d", root.data);
                System.out.print(" ");
                inOrder(root.right);
            }
        }
        
        public void preOrder(Node root){
            if (root != null){
                System.out.printf("%d", root.data);
                System.out.print(" ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }
        
        public void postOrder(Node root){
            if(root != null){
                postOrder(root.left);
                postOrder(root.right);
                System.out.printf("%d", root.data);
                System.out.print(" ");
            }
        }

    }
    
    public static class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    // Data Fields

    /** Return value from the public add method. */
        protected boolean addReturn;
    /** Return value from the public delete method. */
        protected E deleteReturn;

    //Methods
    /*<listing chapter="6" number="3">*/
    /**
     * Starter method find.
     * @pre The target object must implement
     *      the Comparable interface.
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
        public E find(E target) {
            return find(root, target);
        }

    /**
     * Recursive find method.
     * @param localRoot The local subtree�s root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
        private E find(Node<E> localRoot, E target) {
           if (localRoot == null) {
                return null;
            }

        // Compare the target with the data field at the root.
           int compResult = target.compareTo(localRoot.data);
            if (compResult == 0) {
               return localRoot.data;
            } else if (compResult < 0) {
                return find(localRoot.left, target);
            } else {
                return find(localRoot.right, target);
            }
        }
    /*</listing>*/

    /*<listing chapter="6" number="4">*/
    /**
     * Starter method add.
     * @pre The object to insert must implement the
     *      Comparable interface.
     * @param item The object being inserted
     * @return true if the object is inserted, false
     *         if the object already exists in the tree
     */
        public boolean add(E item) {
           root = add(root, item);
           return addReturn;
        }

    /**
     * Recursive add method.
     * @post The data field addReturn is set true if the item is added to
     *       the tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the
     *         inserted item
     */
        public Node<E> add(Node<E> localRoot, E item) {
            if (localRoot == null) {
            // item is not in the tree � insert it.
                addReturn = true;
                return new Node<E>(item);
            } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
                addReturn = false;
                return localRoot;
            } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
             localRoot.left = add(localRoot.left, item);
                return localRoot;
            } else {
                // item is greater than localRoot.data
                localRoot.right = add(localRoot.right, item);
                return localRoot;
            }
        }
    /*</listing>*/

    /*<listing chapter="6" number="5">*/
    /**
     * Starter method delete.
     * @post The object is not in the tree.
     * @param target The object to be deleted
     * @return The object deleted from the tree
     *         or null if the object was not in the tree
     * @throws ClassCastException if target does not implement
     *         Comparable
     */
        public E delete(E target) {
            root = delete(root, target);
            return deleteReturn;
        }

    /**
     * Recursive delete method.
     * @post The item is not in the tree;
     *       deleteReturn is equal to the deleted item
     *       as it was stored in the tree or null
     *       if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain
     *         the item
     */
        private Node<E> delete(Node<E> localRoot, E item) {
            if (localRoot == null) {
            // item is not in the tree.
                deleteReturn = null;
                return localRoot;
            }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    /*</listing>*/

// Insert solution to programming exercise 1, section 4, chapter 6 here

    /*<listing chapter="6" number="6">*/
    /**
     * Find the node that is the
     * inorder predecessor and replace it
     * with its left child (if any).
     * @post The inorder predecessor is removed from the tree.
     * @param parent The parent of possible inorder
     *        predecessor (ip)
     * @return The data in the ip
     */
        private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
            if (parent.right.right == null) {
                E returnValue = parent.right.data;
                parent.right = parent.right.left;
                return returnValue;
            } else {
                return findLargestChild(parent.right);
            }
        }
        
        public boolean remove(E tar){
            return delete(tar) != null;
        }
        
        public boolean contains(E tar){
            return find(tar) != null;
        }
        
        public String toString(Node root, StringBuilder sb){
            
            if(root != null){
                toString(root.left, sb);
                sb.append(root.data);
                toString(root.right, sb);
                
            }  
            return sb.toString();
        }
        
        public String toString(){
            StringBuilder sb = new StringBuilder();
            return toString(root, sb);
        }
    }
    
    public static class Node<E> implements Serializable {
            // Data Fields
            
            /** The information stored in this node. */
                public E data;
           /** Reference to the left child. */
           public Node<E> left;
            /** Reference to the right child. */
           public Node<E> right;
            
        // Constructors
        /**
         * Construct a node with given data and no children.
         * @param data The data to store in this node
         */
            public Node(E data) {
                this.data = data;
                left = null;
                right = null;
            }

        // Methods
        /**
         * Returns a string representation of the node.
         * @return A string representation of the data fields
         */
            @Override
            public String toString() {
                return data.toString();
            }
        }
}
