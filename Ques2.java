import java.util.*;

public class Ques2 {
    public static class BST {
        int data;
        BST left;
        BST right;
        BST()
        {
            left = null;
            right = null;
        }
        BST(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static BST createNewNode(int data)
    {
        BST temp = new BST();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }
    public static BST insert(BST root, int data)
    {
        if(root == null)
        {
            root = createNewNode(data);
            return root;
        }
        if(root.data > data)
        {
            root.left = insert(root.left,data);
        }
        else if(root.data < data)
        {
            root.right = insert(root.right,data);
        }
        return root;
    }
    public static int getHeight(BST root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int leftHeight = 1 + getHeight(root.left);
            int rightHeight = 1 + getHeight(root.right);

            return Math.max(leftHeight,rightHeight);
        }
    }
    static Stack<Integer> getOrder = new Stack<Integer>();
    public static void getLevelOrder(BST root)
    {
        int h = getHeight(root);
        for(int i = 0 ; i < h ; i++)
        {
            getLevel(root,i);
        }
        System.out.println();
    }
    public static void getLevel(BST root, int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == 0)
        {
            getOrder.push(root.data);
        }
        else
        {
            getLevel(root.left,level - 1);
            getLevel(root.right,level - 1);
        }
    }
    public static void main(String[] args)
    {
        BST root = new BST(40);
        root = insert(root,30);
        root = insert(root,70);
        root = insert(root,20);
        root = insert(root,35);
        root = insert(root,50);
        root = insert(root,80);
        getLevelOrder(root);
        while(!getOrder.empty())
        {
            System.out.print(getOrder.peek() + " ");
            getOrder.pop();
        }
    }

}