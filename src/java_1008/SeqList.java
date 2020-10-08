package java_1008;

public class SeqList {
    private  int[] datas = new int[100];
    private  int size;
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
    //1,获取pos位置的元素，并返回元素值，方法getpos.
    public  int getPos(int pos){//int可以返回null,也可以返回一个具体的数值。
        return datas[pos];
    }
    //2,将pos位置的元素换为data，方法setpos
    public void setPos(int pos, int data){
        datas[pos] = data;
    }
    //4,查找某个元素对应的位置,方法search。
    public int search(int toFind){
        for(int i = 0; i < size; i ++){
            if(datas[i] == toFind){
                return i;//返回的是元素的下标。
            }
        }
        return -1;
    }
    //3,删除第一处出现的元素的值,方法remove
    public void remove(int toRemove){
        //1，先找到toRemove对应元素的下标,直接调用search方法
        int pos = search(toRemove);//返回的是下标。
        if(pos == -1){
            //就是说没有找到
            return;
        }
        //2，要是下标是最后一个，则直接尾删。
        if(pos == size-1){
            size--;
        }
        //3，如果下标是中间元素，要先搬运再删除。
        for(int i = pos; i < size-1; i++){
            datas[i] = datas[i+1];
        }
        size--;
    }
    //4,清空顺序表
    public void clear(){
        size = 0;
    }
}
