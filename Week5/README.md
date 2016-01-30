1. Describe alternative methods for handling collisions in a Hash Table. 不同方法解决hash冲突。

2. Explain the difference between a HashSet and a HashMap

3. Define the notion of edit distance. 编辑距离的概念。

4. HashTable Idea: If I want to add something into an array, could I find a way to translate it into index.
	Average Cost: O(1) lookup, insert, remove

5. hash function的实现也有很多种！！！比较常用的就是 取模法 K mod N, N is the size of hash table.
注意对于字符串作为key, 实现hash function的时候，涉及到一个magic number.

6. How to handle collision?
【1】Linear Probing：just put it in the next available spot， check subsequence postion. 注意：有可能造成full
【2】Random Probing is an alternative with trade-off.
【3】Seperate Chaining.

	Drawback 1： Resizing, when a hash table gets full, the best thing to do is resize it. Requires you create a new
table, new hash function, and reinserting everything. 注意：resize cost是很大的！
	
	Drawback 2: no data ordering.

7. 多去看看面试基础知识笔记整理！！！！！

8. 



