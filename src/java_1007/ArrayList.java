package java_1007;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class ArrayList {
    //冒泡排序法,降序法排列
    public static void bubbleSort(int[] arr){
        for(int cur = 0; cur < arr.length-1; cur++){
            for(int bound = 0; bound < arr.length-1-cur; bound++){
                if(arr[bound] < arr[bound+1]){
                    int tmp = arr[bound];
                    arr[bound] = arr[bound + 1];
                    arr[bound + 1] = tmp;
                }
            }
        }
    }
    //二分查找法，找元素，并返回找到的下标
    public static int binarySearch(int[] arr, int toFind){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(toFind < arr[mid]){
                right = mid - 1;
            }else if(toFind > arr[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
