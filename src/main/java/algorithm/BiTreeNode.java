package algorithm;

/**
 * @desc 重建二叉树
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/11.
 */
public class BiTreeNode {
    public int value;
    public BiTreeNode left;
    public BiTreeNode right;

    public BiTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    private static BiTreeNode constructCore(int[] preOrder, int
            startPreIndex, int endPreIndex, int[] inOrder, int startInIndex, int endInIndex) {
        int value = preOrder[startPreIndex];
        BiTreeNode root = new BiTreeNode(value);
        if (startPreIndex == endPreIndex) {//只有一个元素
            if (startInIndex == endInIndex && preOrder[startPreIndex] ==
                    inOrder[startInIndex]) {
                return root;
            }
        }
        int rootIndex = startInIndex;
        while (rootIndex <= endInIndex && inOrder[rootIndex] != value) {
            ++rootIndex;
        }
        if (rootIndex == endInIndex && inOrder[rootIndex] != value) {//出错了
            return null;
        }
        int leftLength = rootIndex - startInIndex;
        int leftPreOrderEndIndex = startPreIndex + leftLength;
        if (leftLength > 0) {
            root.left = constructCore(preOrder, startPreIndex + 1,
                    leftPreOrderEndIndex,
                    inOrder, startInIndex, rootIndex - 1);
        }
        if (leftLength < endPreIndex - startPreIndex) {
            root.right = constructCore(preOrder, leftPreOrderEndIndex + 1,
                    endPreIndex,
                    inOrder, rootIndex + 1, endInIndex);
        }
        return root;
    }
}
