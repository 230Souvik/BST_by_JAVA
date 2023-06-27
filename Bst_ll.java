
package bst_ll;
import java.util.*;
 
public class Bst_ll {
static class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }}
    
    // node root=null;
     public static node create(node root,int data){
       
        if(root==null){
            root=new node(data);
            return root;
        }
        else
         {
             if (data <= root.data)
                 root.left = create(root.left, data);
             else
                 root.right = create(root.right, data);
         }
         return root;
    }
     public static void inorder(node root){
         
         if(root!=null){
             inorder(root.left);
         System.out.println(root.data);
         inorder(root.right);
         }
     }
     public static void preorder(node root){
      
         if(root!=null){
              System.out.println(root.data);
             preorder(root.left);
        
         preorder(root.right);
         }   
     }
     public static void postorder(node root){
        
         if(root!=null){
              
             postorder(root.left);
        
        postorder(root.right);
        System.out.println(root.data);
     }}
     
     public static void search(node root,int data){
         if(root==null)
             System.out.println("empty");
         else{
             if(root.data==data)
                 System.out.println("data found");
             else if(data<root.data)
                 search(root.left,data);
             else
                 search(root.right,data);
         }
     }
     
     public static node delete(node root,int data){
         if(root.data>data){
             root.left=delete(root.left,data);
         }
         else if(root.data<data){
             root.right=delete(root.right,data);
         }
         else{
             if(root.left==null && root.right==null)
                 return null;
             else if(root.left==null)
                 return root.right;
             else if(root.right==null)
                 return root.left;
             else{
                 node is=inordersucc(root.right);
                 root.data=is.data;
                 root.right=delete(root.right,is.data);
             }
         }
         return root;
     }
     public static node inordersucc(node root){
         while(root.left!=null){
             root=root.left;
         }
         return root;
     }
     
    public static void main(String[] args) {
        // TODO code application logic here
        Bst_ll b=new Bst_ll();
        Scanner scan = new Scanner(System.in);
          node root=null;
          System.out.println("Linked List Binary Search Tree Test\n");          
         char ch;
           do    
         {
        Scanner sc=new Scanner(System.in);
             System.out.println("1. insert data\n2. search data\n3. inorder\n4. preorder\n5. postorder\n6. delete");
             int j=sc.nextInt();
        switch(j){
            case 1:{
        int data;
        System.out.println("enter data");
        data=sc.nextInt();
        root=create(root,data);
        break;
        }
            case 2:{
                int data;
        System.out.println("enter search data");
        data=sc.nextInt();
        search(root,data);
        break;
            }
             case 3:{
                     System.out.println("inorder is");
                     inorder(root);
                     break;
                 }
                 case 4:{
                     System.out.println("preorder is");
                     preorder(root);
                     break;
                 }
                 case 5:{
                      System.out.println("postorder is");
                     postorder(root);
                     break;
                 }
                 case 6:{
                     System.out.println("enter delete element");
                     int data=scan.nextInt();
                     root=delete(root,data);
                 }
        }
         System.out.println("\nDo you want to continue (Type y or n) \n");
             ch = scan.next().charAt(0);                        
         } while (ch == 'Y'|| ch == 'y');
           
//           System.out.println("1. inorder\n 2. preorder\n 3. postorder");
//             int i=scan.nextInt();
//             switch(i){
//                 case 1:{
//                     System.out.println("inorder is");
//                     inorder(root);
//                     break;
//                 }
//                 case 2:{
//                     System.out.println("preorder is");
//                     preorder(root);
//                     break;
//                 }
//                 case 3:{
//                      System.out.println("postorder is");
//                     postorder(root);
//                     break;
//                 }
//             }
//             int data;
//        System.out.println("enter serch data");
//        data=scan.nextInt();
//        b.search(root,data);
    }
    
}
