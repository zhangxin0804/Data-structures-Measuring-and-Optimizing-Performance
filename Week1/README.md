1. How the Flesch Readability Score can be used to determine the readability of text?

2. Regular Expression正则表达式。

3. 通过 Flesch Readability Score可以用来衡量一段文字的可读性readability of text。

4. Measure of text readability

Flesch score = 206.835 - 1.015 * ( #words/#sentences ) - 84.6 * ( #syllables/#words )
	🔼                                   🔼                              🔼
quantifies                              term1  					        term2
readability

注意term1, 实际上表达的就是 平均每个sentence包含多少个words
注意term2, 实际上表达的就是 平均每个word包含多少个syllables(音节)


情况1：
short sentence and short word 即短的句子和短的单词 --> term值相对low --> Flesch score相对high ( >90 easy to read )

情况2：
long sentences and long word 即长的句子和音节较多的长单词 --> term值相对hight --> Flesch score相对low ( <30 difficult to read )

5. 注意两个常量参数，1.015和84.6是两个weight value权值，用于公式中的计算。 表示的含义是，longer words make text a little more
difficult to read than longer sentences.

6. 在Java中，字符串String是对象object, 是在heap上创建的。简单的来看，String are represented as an array of characters.

7. 在Java中，String is immutable which means no way to change it.

8. 
String	concat(String str)
Concatenates the specified string to the end of this string.
这个API返回的是一个新的String对象。

9. 一个新的概念叫做 interned string就是表示one object.

【1】String text = new String("Hello World!");
【2】String text1 = "Hello World!";
【3】String text2 = "Hello World!";

注意：
【1】不管字符串池中是否存在"Hello World!" ，直接新建一个字符串"Hello World!"（注意：新建的字符串"Hello World!" 
不是在字符串池中而是在heap中）,然后将其赋给text.

【2】和【3】这种方式，没有explictly使用new关键字来创造的字符串对象，叫做interned string, 它们是string pool里的string.
首先查看字符串池中是否存在字符串"Hello World!" ，如果存在则直接将"Hello World!"地址赋给text1 ，如果不存在则先在字符串池中新建一个
字符串"Hello World!"，然后再将其赋给text1

【2】【3】效率高。【1】效率低，因为相当于new一个新对象在内存中。综上，创建字符串有两种方式：两种内存区域（pool vs heap）

Useful Link: http://blog.sina.com.cn/s/blog_7c447f810100wf1j.html

10. 

