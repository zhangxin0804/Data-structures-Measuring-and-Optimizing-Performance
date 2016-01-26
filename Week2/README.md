1. asymptotic [,æsɪmp'tɒtɪk] 渐进的

2. benchmark 基准,标准检查程序

3. Use Java timing libraries to measure execution time.

4. Asymptotic Analysis, 渐进的分析

5. Big O is upper bound.

6. 注意讨论大O即Big O时，我们一般是指tight upper bound. 如果不tight的话，比如 nlogn + n,其Big O可以为O(nlogn), 也可以为O(n^2)
只不过O(n^2)并不是tight upper bound.

7. best case, average case, and worst case.

8.                   Best Case           Worst Case          Avg Case

Selection Sort         O(n^2)               O(n^2)            O(n^2)
Insertion Sort         O(n)                 O(n^2)            O(n^2)
Merge Sort             O(nlogn)             O(nlogn)          O(nlogn)
Quick Sort             O(nlogn)             O(n^2)            O(nlogn)

9. Merge Sort: Basic Algorithm
	If list has one element, return

	Divide list in half
	Sort first half (recursion)
	Sort second half (recursion)

	Merge Sorted list

10. 对一段code snippet进行复杂度分析时，要注意这段code中是否涉及到一些method calls, 别忘了要去分析这些method calls的时间复杂度，再来
分析整体的时间复杂度。

11. Java Virtual Machine is an abstraction of computer.

12. Java Compiler maker choices that affect performance.

13. Operating System will affect performance.

14. Running time of a program is influenced by a lof of things.

15. Performance的定义有很多种，不一定是指running time, 还有可能比如power comsumption功耗等等，不过这门课里我们只讨论running time.

16. Benchmarking
    (1) Allow us to compare machines by running the same program.
    (2) Allow us to compare different programs in a same machine.

17. Java的System类，提供了timing的函数。
static long	nanoTime()
Returns the current value of the running Java Virtual Machine's high-resolution time source, in nanoseconds.

For example, to measure how long some code takes to execute:

 long startTime = System.nanoTime(); // 得到的是多少纳秒ns
 // ... the code being measured ...
 long estimatedTime = System.nanoTime() - startTime; // 得到的是多少纳秒ns


18. 




