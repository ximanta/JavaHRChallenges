package com.stackroute.hackerrankchallenge;

/*
Berland has a long and glorious history. To increase awareness about it among younger citizens, King of Berland decided to compose an anthem.
Though there are lots and lots of victories in history of Berland, there is the one that stand out the most. King wants to mention it in the anthem as many times as possible.
He has already composed major part of the anthem and now just needs to fill in some letters. King asked you to help him with this work.
The anthem is the string s of no more than 105 small Latin letters and question marks. The most glorious victory is the string t of no more than 105 small Latin letters. You should replace all the question marks with small Latin letters in such a way that the number of occurrences of string t in string s is maximal.
Note that the occurrences of string t in s can overlap. Check the third example for clarification.

Input
The first line contains string of small Latin letters and question marks s (1 ≤ |s| ≤ 105).

The second line contains string of small Latin letters t (1 ≤ |t| ≤ 105).

Product of lengths of strings |s|·|t| won't exceed 107.

Output
Output the maximum number of occurrences of string t you can achieve by replacing all the question marks in string s with small Latin letters.

Examples
input
winlose???winl???w??
win
output
5
input
glo?yto?e??an?
or
output
3
input
??c?????
abcab
output
2
Note
In the first example the resulting string s is "winlosewinwinlwinwin"

In the second example the resulting string s is "glorytoreorand". The last letter of the string can be arbitrary.

In the third example occurrences of string t are overlapping. String s with maximal number of occurrences of t is "abcabcab".
 */
public class BerlandAnthem {
}
