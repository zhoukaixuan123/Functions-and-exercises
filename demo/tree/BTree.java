/**
 *
 * 功能描述: 
 *
 * @param:      遍历二叉树
 * @return: 
 * @auther: kaixuan
 * @date: 2019/3/10 20:58
 *
 *    二叉树的遍历分为以下三种：
 *
 * 先序遍历：遍历顺序规则为【根左右】
 *
 * 中序遍历：遍历顺序规则为【左根右】
 *
 * 后序遍历：遍历顺序规则为【左右根】
 *
 * 什么是【根左右】？就是先遍历根，再遍历左孩子，最后遍历右孩子
 *
 *
 *
 * 它的前序遍历顺序为：ABDGHCEIF（规则是先是根结点，再前序遍历左子树，再前序遍历右子树）
 *
 * 它的中序遍历顺序为：GDHBAEICF（规则是先中序遍历左子树，再是根结点，再是中序遍历右子树）
 *
 * 它的后序遍历顺序为：GHDBIEFCA（规则是先后序遍历左子树，再是后序遍历右子树，再是根结点）
 *
 */

public class BTree {
    public int data;
    //节点   根节点   左孩子  右孩子
    public BTree father,leftSon,rightSon;
    public static BTree root;

    public boolean hasleft(){
        return leftSon!=null;
    }
    public boolean hasright(){
        return rightSon!=null;
    }

    public BTree(){
    }
    //直接插入方法
    public void insert(int data){
         if (root==null) {
        root=new BTree();
        root.data=data;
        return;
         }

         insert(data,root);
    }


    //递归插入方法
    public void insert(int data, BTree father) {

      //插入的数据和父节点比较大小
        int compare = data - father.data;
        if (compare == 0) {
            return;
        }
       //放在右边
        if (compare > 0) {
         //判断有没有右孩子，如果有则递归下一级
            if (father.hasright()) {
                insert(data, father.rightSon);
            } else {
           //创建一个新的节点没有左孩子
                father.rightSon = new BTree();
                father.rightSon.data = data;
                father.rightSon.father = father;
            }
        }
        if (compare < 0) {
            //判断有没有左孩子，如果有则递归下一级
            if (father.hasleft()) {
                insert(data, father.leftSon);
            } else {
                father.leftSon = new BTree();
                father.leftSon.data = data;
                father.leftSon.father = father;
            }
        }

    }



    //先序遍历
    public static void query1(){
        if (root==null) {
            return;
        }
        query1(root);

    }

    public static void query1(BTree tree) {
        if (tree == null) {
            return;
        }
        if(tree.data == 32){
            System.out.println(tree.data+"++++++++++++++++++++++=");
            return;
        }
        System.out.print(tree.data + "-----");
        if (tree.hasleft()) {
            query1(tree.leftSon);
        }
        if (tree.hasright()) {
            query1(tree.rightSon);
        }
    }


    //中序遍历
    public static void query2(){
        if (root==null) {
            return;
        }
        query2(root);

    }

    public static void query2(BTree tree) {
        if (tree == null) {
            return;
        }
        if (tree.hasleft()) {
            query2(tree.leftSon);
        }
        System.out.print(tree.data + " ?");

        if (tree.hasright()) {
            query2(tree.rightSon);
        }
    }


    //后序遍历
    public static void query3() {
        if (root == null) {
            return;
        }
        query3(root);

    }

    public static void query3(BTree tree) {
        if (tree == null) {
            return;
        }
        if (tree.hasleft()) {
            query3(tree.leftSon);
        }
        if (tree.hasright()) {
            query3(tree.rightSon);
        }

        System.out.print(tree.data + " ?");


    }


    public static void main(String[] args) {
        BTree tree = new BTree();
        tree.insert(56);
        tree.insert(23);
        tree.insert(98);
        tree.insert(33);
        tree.insert(54);
        tree.insert(44);
        tree.insert(66);
        tree.insert(53);
        tree.insert(75);
        tree.insert(11);
        tree.insert(32);
        tree.insert(76);
        //先序遍历
        BTree.query1();
        System.out.println();
        //中序遍历
        BTree.query2();
        System.out.println();
        //后序遍历
        BTree.query3();
    }



}
