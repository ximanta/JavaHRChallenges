package com.stackroute.hackerrankchallenge;
/*
Sheldon has a crush on one of his classmates, but he is afraid to ask her out and he thinks shes's out of his league. He is seen plucking petals of flowers all day long saying she loves me ..., she loves me not ...
        His wicked friend Froot Loops who is also a student of probability wants to have fun. He suggests Sheldon to increase the randomness of his event. He gave Sheldon a finite binary bit stream (like a large binary number) and calls it his 'Love Stream'. He also gave an integer  (Love quotient). Sheldon moves through the love stream from start and alternately says "She loves me" - "She loves me not" at instances when the already traced love stream is divisible by Love Quotient. Sheldon is not good at maths (unfulfilled love has clotted his mind) and seeks your help .
        You are given the bit stream, you need to output " She loves me" - " She loves me not" alternatively (starting from she loves me) at instances when the love stream is divisible by , where  is the index of the stream position till where the binary number stream is divisible by . (1 base indexed)

        Input Format

        integer  denoting number of test cases
        T test cases follow, for each test case:
        integer
        bit stream with end of stream denoted by character 'e'

        1 ≤ T ≤ 20
        2 ≤ N ≤ 100
        1 ≤ BitStream ≤ 1,000,000
        Output Format

        For each test case output " She loves me" - " She loves me not" alternatively (starting from she loves me)at instances when the Love stream already read is divisible by
        Test cases should be separated by a blank line

        Sample Input

        3
        5
        101011e
        6
        1100101011011010101100101e
        7
        110100001010100101010101010101e

        Sample Output

        3 She loves me
        4 She loves me not

        3 She loves me
        4 She loves me not
        16 She loves me

        16 She loves me
        17 She loves me not
        22 She loves me
        23 She loves me not
        28 She loves me
        29 She loves me not

        Explanation

        test case 1: 101011, N = 5
        1. 1(decimal 1)
        2. 10(2)
        3. 101(5) divisible by 5
        4. 1010(10) divisible by 5
        5. 10101(21)
        6. 101011(43)
*/
public class LoveStream {
    
}
