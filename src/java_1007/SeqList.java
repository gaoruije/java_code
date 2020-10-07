package java_1007;
public class SeqList {
    //这里是创建了一个属性，获取一部分内存，就是一个数组。
    private int[] datas = new int[1000];//容量是1000
    private int size;//初始情况下的size是0，表示有效值
    //1,实现打印的方法,要求打印有效的元素，方法display
    public void display(){//void 是有返回的。
        //创建一个字符串
        String result = "[";
        for(int i = 0; i < size; i++){//打印有效的元素就得用size而不是length。
            result += datas[i];
            if(i < size-1){
                result += ",";
            }
        }
        result += "]";
        System.out.println(result);
    }
    //2,给数组任意的位置插入元素，方法add。
    public void add(int pos,int data) {//pos表示的插入的位置，data是要插入的元素
        //a,判断无效的插入,判断pos的具体值,这个条件放在里边封装就更好了。
        if(pos < 0 || pos > size){
            return;
        }
        //扩容的代码方法。
        if(size > datas.length){
            int[] newDatas = new int[datas.length*2];
            for(int i = 0; i < datas.length; i ++){
                newDatas[i] = datas[i]; //将原来的数组拷贝到新的数组中去了。
            }
            //将扩容后的数组在赋值给原来的数组
            datas = newDatas;
        }
        //尾插元素，就是把元素放在size的位置上，最后一个元素就是size-1，所以放在size上。
        if(pos == size){
            datas[pos] = data;
            size++;//插完后一定得size++。
            return;
        }
        //普通位置插元素。
        for(int i = size - 1; i >= pos; i--){
            datas[i + 1] = datas[i];//先搬运，后赋值。
        }
        datas[pos] = data;
        size++;
        return;
    }
    //3,在数组中寻找指定的元素，有的话就返回true否则返回false
    public boolean contains(int toFind){
        //还是循环访问每一个元素并进行和toFind 比较
        //要是相等了就说明找到了，就是返回true，没有了就是返回false
        for(int i = 0; i < size; i++){
            if(datas[i] == toFind){
                return true;
            }
        }
        return false;
    }
    //4,查找某个元素对应的位置,方法search。
    public int search(int toFind){
        for(int i = 0; i < size; i ++){
            if(datas[i] == toFind){
                return i;
            }
        }
        return -1;
    }
}
