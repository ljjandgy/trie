import module.TrieNode;
import utils.FileUtils;
import utils.TrieUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //读取文件
        List<String> wordList = FileUtils.readFile("D://dictionary.txt");
        //初始化字典树
        TrieNode root = new TrieNode('\u0000', 0, new HashMap<Character, TrieNode>());
        //构建字典树
        wordList.forEach(word->TrieUtils.addTrieNode(word,root));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入想要搜素的内容：");
        String prefix = scanner.nextLine();
        //获取前缀匹配的单词数
        System.out.println("在词典中搜索到"+TrieUtils.countPrefix(prefix,root)+"个匹配单词");
        //获取前缀匹配的单词
        System.out.println("匹配单词如下所示：");
        TrieUtils.findMatchWords(prefix,root).forEach(System.out::println);
    }
}
