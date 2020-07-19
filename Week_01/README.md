## 学习笔记

### 第一周学习总结

- 数组、链表、跳表

  > 1. 数组需要一块连续的存储空间，按照数组下标随机访问元素的时间复杂度是O(1),但是增加和删除元素操作的时间复杂度是O(n)，因为涉及到数据的搬移来保持内存空间的连续性
  > 2. 链表(单链表、双向链表、循环链表)，是由零散的内存块串联起来，随机访问元素的时间复杂度是O(n)，数据的查找只能是从头开始遍历；增加和删除元素的时间复杂度是O(1)，删除是指已知元素的位置
  > 3. 跳表，对于**有序链表**增加多级索引结构。插入、删除、查找元素的的时间复杂度是O(log n)

- 栈、队列、优先队列、双端队列

  > 1. 栈是一种先入后出的操作受限的数据结构，只能在一端对数据进行操作，增加和删除元素的时间复杂度O(1)，查找元素的时间复杂度是O(n)
  > 2. 队列是一种先入先出的数据结构，增加和删除元素的时间复杂度是O(1),查找元素的时间复杂度是O(n)
  > 3. 优先队列
  > 4. 双端队列是可以再两端都可以进行数据的删除和插入操作(队列只能是在一端插入、另外一端删除)，增加和删除元素的时间复杂度是O(1)，查找元素的时间复杂度是O(n)

- 哈希表、映射、集合

  > 1. 哈希表是一种key、value型的数据结构，把key通过某种方法将其转换为数组下标的方法称之为哈希函数，哈希表也正是利用了数组按照下标随机访问元素的特性，实现在O(1)的时间复杂度内进行元素的查找。
  > 2. 哈希表的增加、删除、查询操作的时间复杂度是O(1),空间复杂度是O(n),这里也利用到了一个空间换时间的思想

### 第一周课后作业

#### 1. 改写 Deque 代码

```java
/**
 * 用addLast、addFirst、getFirst、getLast
 * removeLast、removeFirst
 */
public class NewDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        System.out.println(deque);

        String string = deque.getFirst();
        System.out.println(string);
        String string1 = deque.getLast();
        System.out.println(string1);

        deque.removeFirst();
        System.out.println(deque);
    }
}
```

#### 2. 分析 Queue 源码

在Java中Queue是继承接口Collection的一个接口。

添加元素方法：

`boolean add(E e);`

`boolean offer(E e);`

删除队列头部元素方法：

`E remove();`

`E poll();`

查看队列头部元素方法：

`E element();`

`E peek();`

其中，add、remove、element操作失败会抛出异常，而offer、poll、peek的操作是返回特殊值

#### 3. 分析 Priority Queue 的源码

Java中的优先队列是保证每次取出的都是权值最小的，元素的大小可以通过元素的自然顺序和构造时传入的比较器来判断。

继承了抽象类 AbstractQueue，实现了Queue接口。不允许放入null元素，是通过**完全二叉树实现的小顶堆**来实现的，既然使用到的是完全二叉树，那么底层是通过**数组**来实现的。

抽象类 AbstractQueue 实现了Queue接口的add、remove、element方法，而这三种操作内部分别调用了offer、poll和peek方法，所以要想实现抽象类 AbstractQueue，则需要实现offer、poll、peek方法。

> 数组坐标是从零开始的，坐标为n(n < length / 2)的节点：
>
> 父节点 = (n - 1) / 2;
>
> 左子节点 = 2 n + 1;
>
> 右子节点 = 2 n + 2;

##### 1. 重要字段

```java
private static final int DEFAULT_INITIAL_CAPACITY = 11; // 默认初始大小
int size; // 队列中实际元素的个数
private final Comparator<? super E> comparator; // 比较器，确定优先级
```

##### 2. 构造函数

```java
// 默认自然顺序，默认初始容量
public PriorityQueue() {    
    	this(DEFAULT_INITIAL_CAPACITY, null);
	}
// 自定义初始容量
public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }
// 自定义比较器
public PriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }
// 自定义初始容量和比较器
public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }
```

##### 3. 重要方法

- add添加操作

  ```java
  public boolean add(E e) {    
      	return offer(e); // 调用offer方法
  	}
  
  public boolean offer(E e) {
          if (e == null)  // 不允许为null
              throw new NullPointerException();
          modCount++;
          int i = size;
          if (i >= queue.length)
              grow(i + 1);  // 是否需要扩容
          siftUp(i, e); // 自下往上堆化，添加元素
          size = i + 1;
          return true;
      }
  ```

- grow方法

  ```java
  private void grow(int minCapacity) {    
      	int oldCapacity = queue.length;    // Double size if small; else grow by 50%  
      	// 容量大于64变为原来的1.5倍，小于64，2倍 + 2
      	int newCapacity = oldCapacity + ((oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1));    // overflow-conscious code    
     		if (newCapacity - MAX_ARRAY_SIZE > 0)        
          	newCapacity = hugeCapacity(minCapacity);    
     	 	queue = Arrays.copyOf(queue, newCapacity);   // 数组赋值
  	}
  ```

- siftUp 方法中的 siftUpComparable 方法

  ```java
  // 自小往上堆化
  private void siftUpComparable(int k, E x) {
          Comparable<? super E> key = (Comparable<? super E>) x;
          while (k > 0) {
              int parent = (k - 1) >>> 1;   // 父节点
              Object e = queue[parent];
              if (key.compareTo((E) e) >= 0)   // 父节点与元素比较
                  break;
              queue[k] = e;    // 继续往上查找
              k = parent;
          }
          queue[k] = key;  // 赋值
      }
  ```

- poll方法

  ```java
  public E poll() {
          if (size == 0)
              return null;
          int s = --size;
          modCount++;
          E result = (E) queue[0];  // 取出队列第一个元素
          E x = (E) queue[s];
          queue[s] = null;  // 删除最后一个元素
          if (s != 0)
              siftDown(0, x);    // 将队列最后一个元素放入到第一个元素进行从上往下堆化 
          return result;
      }
  ```

- siftDownComparable 方法，

  ```
  private void siftDownComparable(int k, E x) {
          Comparable<? super E> key = (Comparable<? super E>)x;
          int half = size >>> 1;        // 非叶子节点
          while (k < half) {
              int child = (k << 1) + 1; // 左孩子
              Object c = queue[child];
              int right = child + 1;  // 右孩子
              if (right < size &&
                  ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                  c = queue[child = right];   // 找左右孩子中的最小值
              if (key.compareTo((E) c) <= 0)   // 最小值与该元素比较
                  break;
              queue[k] = c;  // 继续往下寻找
              k = child;
          }
          queue[k] = key;
      }
  ```

- peek方法

  ```java
  public E peek() {    
      	return (size == 0) ? null : (E) queue[0];  // 队列收首元素
  	}
  ```

##### 总结

- 在 Java 中，优先队列是基于完全二叉树的小顶堆，底层数据结构是数组
- 非线程安全
- 不支持null值