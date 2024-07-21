import java.util.LinkedList;
import java.util.Queue;

public class BT00 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;

            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            System.out.print("-1 "); // optional
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currentNode.data +  " ");
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
        }
    }

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNode = countOfNodes(root.left);
        int rightNode = countOfNodes(root.right);

        return leftNode+rightNode+1;
    }

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftSum  =   sumOfNodes(root.left);
        int rightSum =   sumOfNodes(root.right);

        return  leftSum + rightSum + root.data;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight,rightHeight) + 1;
        return myHeight;
    }

    public static int diameterOfATree(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = diameterOfATree(root.left);
        int diam2 = diameterOfATree(root.right);
        int diam3 = height(root.left)+height(root.right)+1;
        return Math.max(diam3,Math.max(diam1,diam2));
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);


        System.out.print("preorder   : "); preorder(root);   System.out.println();
        System.out.print("inorder    : "); inorder(root);    System.out.println();
        System.out.print("postorder  : "); postorder(root);  System.out.println();
        System.out.println("↓ levelorder ↓"); levelorder(root);
        System.out.println("Number of nodes in the tree : "+countOfNodes(root));
        System.out.println("Sum of nodes in the tree    : "+sumOfNodes(root));
        System.out.println("Height of the binary tree   : "+height(root));
        System.out.println("diameter of a tree : "+diameterOfATree(root));
    }
}