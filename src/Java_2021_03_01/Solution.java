package Java_2021_03_01;

import java.util.Arrays;

public class Solution {
    // 1.题目要求：给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
    // 不仅要返回原来移除过后的数组，并返回移除后数组的新长度。
    public static int removeElement(int[] nums, int val) {
        // a)先要考虑数组为空的情况
        // 要注意的是，nums == null表示的是这里本来就没有箱子，
        // 而后边的 .length == 0 表示的是有箱子，但是给箱子里边没有放任何东西
        if (nums == null || nums.length  == 0) {
            return 0;
        }
        // b)进行删除val的元素
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 因为要返回原来的数组，所以讲值是val的所有的数字见到就跳过
            // 也就是说将值不是val的元素，放在一个数组里边
            if (nums[i] != val) {
                // 这一句代码的含义是输出的是数组，还要将原来的数组打印出来
                nums[count] = nums[i];
                // 因为count每一次都加一个，所以打印出来的数组一定是连续的
                count++;
            }
        }
        return count;
    }
    // 2. 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    public static int searchInsert(int[] nums, int target) {
        // 用二分查找来进行找存在元素的下标，要是没有找见的时候我们的left的位置就是要插入元素的位置
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 一次就找见的情况下的
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {//在分割线的左边，在左边进行找，更新右边的条件
                right = mid - 1;
            } else {// 在分割线的右边，更新左边的条件
                left = mid + 1;
            }
        }
        // 这里说明的就是找完了所有的元素，没有发现要插入的元素的值，返回left
        return left;
    }
    // 3.给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
    // 如果可以构成，返回 true ；否则返回 false。
    //链接：https://leetcode-cn.com/problems/ransom-note
    public static boolean canConstruct(String ransomNote, String magazine) {
        // 1.先统计后边的每个字符的个数
        // 定义一个包含26个整数的数组用来存储每个字母出现的个数
        int[] arr = new int[26];
        // 进行每个字母的个数统计
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        // 进行匹配
        for (int i = 0; i < ransomNote.length(); i++) {
            if (arr[ransomNote.charAt(i) - 'a'] > 0) {// 找到了那个字母
                arr[ransomNote.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
    // 4.给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    //回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
    //链接：https://leetcode-cn.com/problems/palindrome-number
    public static boolean isPalindrome(int x) {
        // 首先发现，要是一个数是负数，一定不是回文数
        if (x < 0) {
            return false;
        }
        // 用一个常量来记录下这个数字的值，再将这个数字进行翻转，与原来的数字进行比较
        int cur = 0;
        int num = x;
        // 进行翻转
        while (num != 0) {
            // 这里有一个将个位变为十位，直接乘10即可
            cur = cur * 10 + num % 10;
            // 每次完成后要更新下num的值
            num /= 10;
        }
        return cur == x;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,45,5,2};
        int n = removeElement(arr,2);
        System.out.println(removeElement(arr,2));
       // System.out.println(Arrays.toString(arr));
       for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // **有个问题
        // System.out.println(Arrays.toString(arr));
//        System.out.println(searchInsert(arr,17));
//        System.out.println(isPalindrome(121));
    }
}
