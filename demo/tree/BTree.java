/**
 *
 * ��������: 
 *
 * @param:      ����������
 * @return: 
 * @auther: kaixuan
 * @date: 2019/3/10 20:58
 *
 *    �������ı�����Ϊ�������֣�
 *
 * �������������˳�����Ϊ�������ҡ�
 *
 * �������������˳�����Ϊ������ҡ�
 *
 * �������������˳�����Ϊ�����Ҹ���
 *
 * ʲô�ǡ������ҡ��������ȱ��������ٱ������ӣ��������Һ���
 *
 *
 *
 * ����ǰ�����˳��Ϊ��ABDGHCEIF�����������Ǹ���㣬��ǰ���������������ǰ�������������
 *
 * �����������˳��Ϊ��GDHBAEICF����������������������������Ǹ���㣬�������������������
 *
 * ���ĺ������˳��Ϊ��GHDBIEFCA���������Ⱥ�����������������Ǻ�����������������Ǹ���㣩
 *
 */

public class BTree {
    public int data;
    //�ڵ�   ���ڵ�   ����  �Һ���
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
    //ֱ�Ӳ��뷽��
    public void insert(int data){
         if (root==null) {
        root=new BTree();
        root.data=data;
        return;
         }

         insert(data,root);
    }


    //�ݹ���뷽��
    public void insert(int data, BTree father) {

      //��������ݺ͸��ڵ�Ƚϴ�С
        int compare = data - father.data;
        if (compare == 0) {
            return;
        }
       //�����ұ�
        if (compare > 0) {
         //�ж���û���Һ��ӣ��������ݹ���һ��
            if (father.hasright()) {
                insert(data, father.rightSon);
            } else {
           //����һ���µĽڵ�û������
                father.rightSon = new BTree();
                father.rightSon.data = data;
                father.rightSon.father = father;
            }
        }
        if (compare < 0) {
            //�ж���û�����ӣ��������ݹ���һ��
            if (father.hasleft()) {
                insert(data, father.leftSon);
            } else {
                father.leftSon = new BTree();
                father.leftSon.data = data;
                father.leftSon.father = father;
            }
        }

    }



    //�������
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


    //�������
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


    //�������
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
        //�������
        BTree.query1();
        System.out.println();
        //�������
        BTree.query2();
        System.out.println();
        //�������
        BTree.query3();
    }



}
