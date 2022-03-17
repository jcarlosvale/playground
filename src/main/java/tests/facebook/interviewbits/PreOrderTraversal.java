package tests.facebook.interviewbits;

import java.util.ArrayList;
import java.util.LinkedList;
import tests.leetcode.challenge30days.dataStructure.TreeNode;

/**
 * NICE SOLUTION
 * 	public ArrayList<Integer> preorderTraversal(TreeNode a) {
 * 	    ArrayList<Integer> list=new ArrayList<>();
 * 	    Stack <TreeNode> st=new Stack<>();
 * 	    st.push(a);
 * 	    //list.add(a.val);
 * 	    while(!st.empty()){
 * 	        TreeNode tr=st.pop();
 * 	        list.add(tr.val);
 * 	        if(tr.right!=null){
 * 	            st.push(tr.right);
 *                        }
 * 	        if(tr.left!=null){
 * 	            st.push(tr.left);
 *                    }
 * 	    }
 * 	       return list;
 * 	}
 */
public class PreOrderTraversal {

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> toVisitLeft = new LinkedList<>();
        LinkedList<TreeNode> toVisitRight = new LinkedList<>();
        if (A != null) toVisitLeft.add(A);
        while(!toVisitLeft.isEmpty() || !toVisitRight.isEmpty()) {
            TreeNode node = null;
            if (!toVisitLeft.isEmpty()) {
                node = toVisitLeft.getFirst();
                toVisitLeft.removeFirst();
            } else {
                node = toVisitRight.getFirst();
                toVisitRight.removeFirst();
            }

            if (node != null) {
                ans.add(node.val);
                if (node.left != null) toVisitLeft.add(node.left);
                if (node.right != null) toVisitRight.addFirst(node.right);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(preorderTraversal(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3), new TreeNode(4)),
                        new TreeNode(5,
                                new TreeNode(6), new TreeNode(7))
                        )
        )); //1 2 3 4 5 6 7
    }
}
