# 排序算法总结
[TOC]
## 常用排序算法  



### 冒泡排序

简介：

1、冒泡排序是一种用时间换空间的排序方法，n小时好  
2、最坏情况是把顺序的排列变成逆序，或者把逆序的数列变成顺序，最差时间复杂度O(N^2)只是表示其操作次数的数量级  
3、最好的情况是数据本来就有序，复杂度为O(n)

代码：

```
    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {

        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
```  


###  选择排序

从前往后，逐个找到最小的元素记录其下标，最终将其移动到已排序队列的末尾，完成一次循环，已排序序列队尾脚标+1，
进入下一轮循环，逐步减小未排序序列、扩大已排序序列，直至所有元素都进入已排序的序列。

代码

```
public void sort(Integer[] array) {

        int n = array.length;
        int minIndex;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            //未排序序列中最小数据数组下标
            minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[minIndex] > array[j]) {
                    //在未排序元素中继续寻找最小元素，并保存其下标
                    minIndex = j;
                }
            }
            //将最小元素放到已排序序列的末尾
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

```


###  插入排序
  
这个算法从数组的第二个元素开始循环，将选中的元素与之前的元素一一比较，如果选中的元素小于之前的元素，则将之前的元素后移，最后再将选中的元素放在合适的位置。在这个算法执行的过程中，总是保持着索引i之前的数组是升序排列的。
插入排序理解起来比较简单，因此LZ就不过多的解释它的实现原理了，尚未理解的猿友可以自行研究。

代码：

```
    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j > -1 && (array[j] > key)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
    
```

### 快速排序
采用分制的思想，以某个值为中间值，将比该值小或比该值大的值分别放置到左右两侧，
形成左右两个新的分组，对左右两个新分组再递归调用方法本身，直到当分组元素为1时停止，
最终实现排序。

代码：

```$xslt

        /**
         * 快速排序 数据结构与算法分析-Java版 实现
         *
         * @param items
         */
        public void sort(List<Integer> items) {
            if (items.size() <= 1) {
                return;
            }

            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);
            for (Integer item : items) {
                if (item < chosenItem) {
                    smaller.add(item);
                } else if (item > chosenItem) {
                    larger.add(item);
                } else {
                    same.add(item);
                }
            }
            sort(smaller);
            sort(larger);
            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
```






## 排序算法对比



类别     |算法名     | 平均时间复杂度 |空间复杂度    |稳定性   |复杂性 | 代码提示      
------- |----------|------------- |------------|--------|------|--------
交换排序 |冒泡排序   | O(N2) |O(1)|稳定|简单|2层for循环
：：     |快速排序   | O(N*log2N) |O(log2n)~O(n)|不稳定|简单|while{while-while-if}
插入排序 |直接插入   | O(N2) |O(1)|稳定|简单|for循环-key-while循环
：：    |希尔排序   |O(N1.3)|O(1)| 不稳定|复杂
选择排序 |直接选择排序| O(N2) |O(1)|不稳定|简单
：：    |堆排序     | O(N*log2N) |O(1)|不稳定|复杂
归并排序 |归并排序   |  O(N*log2N)|O(n)| 稳定| 复杂
基数排序 |基数排序   |  O(d(r+n))|O(d(r+n))| 稳定| 复杂


注：基数排序：r代表关键字基数，d代表长度，n代表关键字个数

思考：为什么快速排序的空间复杂度是lg(n)~n，这是因为快速排序是递归的，每个递归深度都会产生一些临时变量，所以它的空间复杂度跟递归深度有关。

