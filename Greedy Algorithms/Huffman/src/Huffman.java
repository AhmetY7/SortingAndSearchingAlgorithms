/*
Huffman Coding is a technique of compressing data to reduce its size without losing any of the details. It was
first developed by David Huffman.

Huffman Coding is generally useful to compress the data in which there are frequently occurring characters.

The overall complexity is O(nlog n).

Huffman Coding Applications
-Huffman coding is used in conventional compression formats like GZIP, BZIP2, PKZIP, etc.
-For text and fax transmissions.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode {
    int item;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class ImplementComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }
}

public class Huffman {
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + "   |   " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        int n = 4;
        char[] charArray = {'A','B','C','D'};
        int[] charFreq = {5,1,6,3};

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new ImplementComparator());

        for (int i=0; i<n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.item = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size()>1) {
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.item = x.item + y.item;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;

            q.add(f);
        }
        System.out.println(" Char | Huffman code ");
        System.out.println("---------------------");
        printCode(root, "");
    }
}
