import java.util.*;
public class Ques1 {

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
    
    public static void printAufbaus(BST root)
    {

        Queue<BST> q1 = new LinkedList<BST>();
        q1.add(root);
        q1.add(null);

        while(q1.size() != 0)
        {
            BST temp = q1.poll();
            if(temp == null)
            {
                if(q1.size() < 1)
                    return;
                q1.add(null);
            }
            else
            {
                while(temp != null)
                {
                    System.out.print(temp.data +" ");

                    if(temp.right != null)
                    {
                        q1.add(temp.right);
                    }
                    temp =  temp.left;
                }
            }
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

        printAufbaus(root);
    }
}