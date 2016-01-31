1. Tree Data Structure
实际中的一些应用比如：决策树 decision tree, 表达式树 expression tree, 文件系统 file system.
一些比较复杂的tree结构比如：red-black tree红黑树, AVL树。 

	Root is most important – Heap
	Organized by character frequency – Huffman Tree or Compression Tree
	Organized by node ordering – Search Trees
	Etc...

2. Binary Search Tree (BST) V.S. Trie (Prefix Tree)

3. Preorder, Inorder, Postorder, level-order tree traversal. 前序，中序，后序, 层序 树遍历。
Order we visit matters and we'll make choices based on out needs. 可以再去看看刷过的题中的不同实现。


4. Tree Definition (树的定义)

	• Single root
	• Each node can have only one parent. Any parent can have any child nodes.
	• No cycles in a tree. 这个容易忽略！！！

5. 二叉搜索树BST又叫做 sorted binary tree. It allows fast lookup, addition and removal of items. BST keep their keys in sorted order. 二叉搜索树具有下列性质：1）若它的left child不空，则left sub tree上所有节点的值均小于它的根节点的值；若right child不空，则right sub tree所有节点的值均大于它的根节点的值。且它的左右子树也分别为二叉搜索树BST (recursive definition)；2）中序遍历Inorder traversal是升序序列。

6. 注意BST search的实现方式。 其中有一点：Don't change root pointer.

7. 注意BST insert和BST remove的实现方式。

8. There is no rule that BSTs will be full trees( or balanced ). 注意：BST是不是balanced决定着它的一些操作的performance.

9. The order in which we put elements into a binary search tree impacts the shape. And the shape of the binary search tree
will have a huge impact on the performance of operations with that binary search tree.

10. Structure of a BST depends on the order of insertion.

11. How to defin balanced BST?  左右子树高度差不超过1。
 |Left Subtree height - Right Subtree height| <= 1

12. Java already has a built-in implementation of balanced binary search tree  ------ TreeSet类。

13. Trie的常见操作就是 search 和 add. 一般我们假设都是alphabetic字符，这样每一个Trie Node都有固定数量的，可以往下延伸的branches.

14. 注意：虽然Trie相比balanced BST, 在查找的时间效率上更优，但是Trie的一个最大问题就是，空间消耗太大！！！！！！！！

15. 前面提到Trie数据结构在空间上的消耗是比较大的，因为对于每一个TrieNode, 假设只考虑小写字母，那么每一个TrieNode都要往下拓展26个branches, 换句话说如果用array来存储每次都要开辟26个位置来存储下一层的TrieNode, 但其实很多位置都是空的，因此浪费了空间，所以我们可以考虑用HashMap<Character, TrieNode>结构来存储！！节省空间！！

16. 



