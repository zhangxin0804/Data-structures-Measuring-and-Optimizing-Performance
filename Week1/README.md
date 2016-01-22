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

【2】和【3】这种方式，没有explicitly使用new关键字来创造的字符串对象，叫做interned string, 它们是string pool里的string.
首先查看字符串池中是否存在字符串"Hello World!" ，如果存在则直接将"Hello World!"地址赋给text1 ，如果不存在则先在字符串池中新建一个
字符串"Hello World!"，然后再将其赋给text1

【2】【3】效率高。【1】效率低，因为相当于new一个新对象在内存中。综上，创建字符串有两种方式：两种内存区域（pool vs heap）

Useful Link: http://blog.sina.com.cn/s/blog_7c447f810100wf1j.html

10. 如何计算 number of syllables will involve looking at the characters in a string.

11. 注意enhanced for loop的使用，也即for-each loop的使用。增强for循环不能对String对象使用，不过当String调用toCharArray()方法后
可以对该字符数组使用for-each loop.

12. String[]	split(String regex)
Splits this string around matches of the given regular expression.

注意！！Trailing empty strings are therefore not included in the resulting array.
The string "boo:and:foo", for example, yields the following results with these expressions:

Regex	Result
:	{ "boo", "and", "foo" }
o	{ "b", "", ":and:f" }


13. int	indexOf(String str)
Returns the index within this string of the first occurrence of the specified substring.如果找不到，则return -1

14. char[]	toCharArray()
Converts this string to a new character array.相当于是return了一个new copy array.

15. 这门课的porject需要eclipse sdk4.5 + jdk1.8 + javaFX(一个GUI的java framework)
其中starter code导入eclipse可能会遇到对javaFX的jar包的access restriction, 解决方法如下：
http://stackoverflow.com/questions/22812488/using-javafx-in-jre-8








Regular Expression: Characters are base units.
有3种方法，对正则表达式进行扩展：repetition, concatenation, alternation(either/or)
然后可以对这些方法进行组合。

Example 1 (repetition):
--------------
String text = "Hello  hello?"
String[] words = text.split(" +");
￼
Matches 1 or more spaces in a row
--------------


Example 2 (concatenation):
----------------------------

public abstract class Document { 
	...
	protected List<String> getTokens(String pattern){
	...	
	}
}

Assume you have a Document object, d, whose text is
"Splitting a string, it's as easy as 1 2 33! Right?" 

d.getTokens("it"); ---> ["it", "it"]  注意我们是返回的token, 而不是返回按照token split后的内容。
Two regular expressions side by side, matches when both appear one after the other

--------------------------------------------------------


Example 3 (concatenation+repetition)
------------------------------------
Assume you have a Document object, d, whose text is
"Splitting a string, it's as easy as 1 2 33!  Right?"

d.getTokens("it+");  ----> ["itt", "it"]
+ means "one or more"

d.getTokens("i(t+)");  ----> ["itt", "it"]
use parenthesis to explicitly grouping regular expression

d.getTokens("it*"); ---> ["itt", "i", "i", "it", "i"]
* means "zero or more"

------------------------------------------------------------

Example 4 (alternation)
------------------------------------

Assume you have a Document object, d, whose text is
"Splitting a string, it's as easy as 1 2 33!  Right?"

d.getTokens("it|st"); ----> ["it", "st", "it"]
| means OR
------------------------------------


Example 5 (set)
--------------------------------
Assume you have a Document object, d, whose text is
"Splitting a string, it's as easy as 1 2 33!  Right?"

d.getTokens("[123]"); ----> ["1", "2", "3", "3"]
[ ] mean match "anything in the set"
￼￼￼￼￼￼
￼￼￼

Example 6 (range)
------------------------------------

Assume you have a Document object, d, whose text is
"Splitting a string, it's as easy as 1 2 33! Right?" 

d.getTokens("[1-3]"); ----> ["1", "2", "3", "3"]
- indicates a range (any character between 1 and 3)
￼￼￼

Assume you have a Document object, d, whose text is
"Splitting a string, it's as easy as 1 2 33! Right?"

d.getTokens("[a-f]"); --> ["a", "a", "e", "a", "a"]
- indicates a range (any character between a and f)
￼￼￼


Example 7 (Excluding)
-------------------------------
Assume you have a Document object, d, whose text is
"Splitting a string, it's as easy as 1 2 33!  Right?"

d.getTokens("[^a-z123 ]"); ---> ["S", ",", "'", "!", "R", "?"] 
^ indicates NOT any characters in this set

-----------------------------------------------------

Expression 			Matches
￼￼"a*" 			Zero or more a's
￼￼"a+" 			1 or more a's
  "[a-f]" 		Any character between a and f
￼ "[^a-cz]" 	Any character which is not between a-c and not z
￼ "[abc]+" 		1 or more of the character a, b, or c in a row
￼ "abc" 		The characters abc in a row
  "a|b" 	 	The character a or the character b
￼

-----------------------------------------------------







