## 学习笔记

### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

**思路**：给定一个半有序数组，要查找无序的位置，需要满足nums[mid] < nums[mid - 1]或者nums[mid] > nums[mid + 1]

- 若 nums[0] <= nums[mid]，则说明mid左边部分是升序排列的，无序的在mid后面的位置，所以left = mid+ 1
- 若 nums[0] > nums[mid]，则说明无序的位置在0和mid之间，right= mid- 1；
- 终止条件
  - nums[mid] < nums[mid - 1]，return mid
  - nums[mid] > nums[mid + 1]，return mid + 1

**代码**：

```
 class Main {
  public static void search(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid - 1]) {
                System.out.println(nums[mid]);
                return;
            } else if (nums[mid] > nums[mid + 1]) {
                System.out.println(nums[mid + 1]);
                return;
            } else if (nums[mid] >= nums[0])
                left = mid + 1;
            else
                right = mid - 1;
        }
    }
    public static void main(String[] args) {
       int[] a = new int[]{4,5,6,7,0,1,2};
       search(a);
    }
 }
```

### 分治代码模板

```Java
private static int divide_conquer(Problem problem, ) {
  // 递归终止条件
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  subProblems = split_problem(problem) // 分解子问题
  // drill down
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  // 合并子问题结果
  result = process_result(res0, res1);
  
  return result;
}
```

### DFS模板：

```Java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) return list;
    travel(0, root, list);
    return list;
}
private void travel(int level, TreeNode root, List<List<Integer>> list) {
    if (level == list.size()) {
        list.add(new ArrayList<>());
        return ;
    }
    list.get(level).add(root.val);
    if (root.left != null) {
        travel(level + 1, root.left, list);
    }
    if (root.right != null) {
        travel(level + 1, root.right, list);
    }
}
```

### BFS模板：

```Java
public List<List<Integer>> levelOrder (Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return res;
    }
```

### 二分查找代码模板:

```Java
public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
```

