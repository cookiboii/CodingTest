
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Node  {
    char data;
    Node right;
    Node left;
    public  Node(char data)
    {
        this.data=data;
    }
}

public class Main {

    static Node[] tree = new Node[26];
    public static  void  main(String []args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < 26; i++) {
             tree[i]=new Node((char)('A'+i));
        }

        for (int i = 0; i <N ; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());

            char parentChar=st.nextToken().charAt(0);
            char leftChar =st.nextToken().charAt(0);
            char rightChar=st.nextToken().charAt(0);

            Node parent= tree[parentChar-'A'];
            if (leftChar != '.') {
                parent.left= tree[leftChar-'A'];
            }
            if (rightChar != '.') {
                parent.right= tree[rightChar-'A'];
            }
        }
        preorder(tree[0]); // 전위 순회
        System.out.println();

        inorder(tree[0]);  // 중위 순회
        System.out.println();

        postorder(tree[0]); // 후위 순회
        System.out.println();

    }
   public static void preorder(Node node){
        if(node==null) return;
        System.out.print(node.data); //루트
        preorder(node.left);  //왼쪽
        preorder(node.right);  // 오른쪽
   }
 public static void inorder(Node node){
        if(node==null) return;
        inorder(node.left); // 왼쪽
        System.out.print(node.data); // 루트
        inorder(node.right); //오른쪽

 }
 public static void postorder(Node node){
        if(node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
 }
}
