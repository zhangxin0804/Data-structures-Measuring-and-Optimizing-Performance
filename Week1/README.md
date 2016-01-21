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

6. 