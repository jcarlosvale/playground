package tests.leetcode.challenge30days;

import java.io.*;
import java.util.*;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no
 * such integer.
 * void add(int value) insert value to the queue.
 *
 *
 * Example 1:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 *
 * Example 2:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 *
 * Example 3:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 */
public class FirstUnique {

    class DoubleLinkedList {
        int value;
        DoubleLinkedList next;
        DoubleLinkedList previous;
        DoubleLinkedList() {
            this.value = -1;
            this.next = this;
            this.previous = this;
        }
        //insert in the end
        public DoubleLinkedList add(int value) {
            if(this.value == -1) {  //empty list
                this.value = value;
                return this;
            } else {
                DoubleLinkedList newNode = new DoubleLinkedList();
                newNode.value = value;
                newNode.next = this;
                newNode.previous = this.previous;
                this.previous.next = newNode;
                this.previous = newNode;
                return newNode;
            }
        }
        //remove node
        public void remove(DoubleLinkedList node) {
            if (node == null) return;

            if(this.value == node.value) {  //if it is the root, make the copy of next and remove next
                if (this.next.value == this.value) {  //one element only
                    this.value = -1;
                } else {
                    DoubleLinkedList nextNode = this.next;
                    this.value = this.next.value;
                    this.next = nextNode.next;
                    nextNode.next.previous = this;
                    nextNode.next = null;
                    nextNode.previous = null;
                }
            } else {
                node.previous.next = node.next;
                node.next.previous = node.previous;
                node.previous = null;
                node.next = null;
            }
        }
        //is empty
        public boolean isEmpty() {
            return this.value == -1;
        }
    }

    private DoubleLinkedList linkedList;
    private Map<Integer, DoubleLinkedList> uniqueNumbers;

    public FirstUnique(int[] nums) {
        linkedList = new DoubleLinkedList();
        uniqueNumbers = new HashMap<>();
        for (int n : nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        if (linkedList.isEmpty()) {
            return -1;
        }
        return linkedList.value;
    }

    public void add(int value) {
        System.out.println(value);
        if(value == 655) {
            System.out.println("debug");
        }
        if (uniqueNumbers.containsKey(value)) {
            linkedList.remove(uniqueNumbers.get(value));
            uniqueNumbers.put(value,null);
        } else {
            DoubleLinkedList node = linkedList.add(value);
            uniqueNumbers.put(value, node);
        }
    }

    public static void main(String[] args) throws IOException {
        FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
//        System.out.println(firstUnique.showFirstUnique()); // return 2
//        firstUnique.add(5);            // the queue is now [2,3,5,5]
//        System.out.println(firstUnique.showFirstUnique()); // return 2
//        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
//        System.out.println(firstUnique.showFirstUnique()); // return 3
//        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
//        System.out.println(firstUnique.showFirstUnique()); // return -1
//
//        firstUnique = new FirstUnique(new int[]{7,7,7,7,7,7});
//        System.out.println(firstUnique.showFirstUnique()); // return -1
//        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
//        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
//        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
//        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
//        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
//        System.out.println(firstUnique.showFirstUnique()); // return 17
//
//        firstUnique = new FirstUnique(new int[]{809});
//        System.out.println(firstUnique.showFirstUnique()); // return 809
//        firstUnique.add(809);          // the queue is now [809,809]
//        System.out.println(firstUnique.showFirstUnique()); // return -1


//        String [] commands = {
//                "FirstUnique","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add",
//                "add","add","add","add","add","add","add","add","add","add","showFirstUnique","showFirstUnique",
//                "showFirstUnique","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add",
//                "add","showFirstUnique","add","add","add","add","add","add","add","add","showFirstUnique","add","add",
//                "showFirstUnique","add","showFirstUnique","add","add","add","showFirstUnique","add","add","add","add",
//                "add","add","add","add","add","add","add","add","add","add","add","add","add","add","showFirstUnique",
//                "add","showFirstUnique","add","add","add","add","add","add","add","add","add","add","add","add","add",
//                "add","add","add","add","add","showFirstUnique","add","showFirstUnique","add","add","add","add","add",
//                "add","add","add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add",
//                "add","add","add","add","showFirstUnique","add","add","add","add","add","add","add","add","add","add",
//                "add","add","add","add","add","add","add","add","add","showFirstUnique","add","add","add",
//                "showFirstUnique","add","add","add","add","add","add","add","add","add","showFirstUnique","add","add",
//                "add","add","showFirstUnique","showFirstUnique","add","showFirstUnique","showFirstUnique","add",
//                "showFirstUnique","add","add","showFirstUnique"};
//        int [][] parameters =
//                {{439,264,80,424,379,943,654,152,23,613,811,417,554,626,920,450,344,931,444,183, 525,843,310,515,332,966,
//                        774,121,409,194,523,828,850,621,609,739,847,678,189,499,708,594,483,528,902,191,219,297,715,283,
//                        402,962,365,4,577,300,356,892,708,326,98,378,80,736,99,215,472,991,603,612,896,374,104,363,926,
//                        744,862,389,838,636,167,85,274,574,762,163,108,223,79,487,896,32,202,196,751,654,994,627,93,101,
//                        495,379,511,519,151,95,517,209,518,218,905,708,383,768,355,252,982,984,667,239,42,278,76,924,523,
//                        67,169,792,69,135,546,869,670,597,631,4,967,84,696,687,603,897,126,333,912,398,52,350},
//                        {}, {533},{184},{491},{160},{146},{993},{355},{323},{527},{385},{754},{8},{302},{479},{63},{680},
//                        {122},{972},{384},{598},{528},{12},{},{},{},{763},{177},{502},{851},{650},{},{28},{560},{385},
//                        {276},{35},{397},{832},{},{66},{492},{634},{340},{50},{107},{715},{997},{},{85},{746},{},{52},{},
//                        {151},{425},{525},{},{357},{203},{504},{632},{898},{972},{819},{606},{863},{115},{6},{952},{189},
//                        {537},{679},{170},{161},{735},{},{479},{},{549},{631},{446},{132},{249},{667},{817},{712},{942},
//                        {179},{875},{42},{585},{484},{726},{900},{578},{374},{},{660},{},{249},{564},{395},{733},{889},
//                        {487},{422},{746},{291},{290},{296},{},{889},{775},{757},{99},{658},{867},{475},{787},{656},{185},
//                        {964},{73},{},{69},{96},{981},{778},{490},{97},{569},{644},{828},{308},{753},{534},{602},{432},
//                        {238},{168},{339},{33},{717},{},{165},{142},{806},{},{452},{803},{126},{626},{212},{48},{239},
//                        {647},{891},{},{934},{408},{190},{460},{},{},{738},{},{},{315},{},{899},{599},{}};
//        for (int i = 0; i < commands.length; i++) {
//            if (commands[i].equals("FirstUnique")) {
//                firstUnique = new FirstUnique(parameters[i]);
//            }
//            if (commands[i].equals("showFirstUnique")) {
//                System.out.println(firstUnique.showFirstUnique());
//            }
//            if (commands[i].equals("add")) {
//                firstUnique.add(parameters[i][0]);
//            }
//        }

        InputStream inputStream = FirstUnique.class.getClassLoader().getResourceAsStream("inputCommandsFirstUnique.properties");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String line = br.readLine();
        String[] numbers = line.split(",");
        int[] nums = new int[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }
        firstUnique = new FirstUnique(nums);
        firstUnique.add(28);
        firstUnique.add(346);
        firstUnique.add(268);
        firstUnique.add(927);
        System.out.println(firstUnique.showFirstUnique());
    }
}
