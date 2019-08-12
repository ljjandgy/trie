package test;

import module.TrieNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.FileUtils;
import utils.TrieUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @ClassName TrieTest
 * @Description
 * @Author ljj
 * @Version V2.0.0
 * @Date 2019-08-12 09:27:27
 */
public class TrieTest {
    private TrieNode root = new TrieNode('\u0000', 0, new HashMap<>());

    private static final Random RANDOM = new Random();

    private static final int TEST_NUM = 1000;
    @Before
    public void initTrie(){
        List<String> wordList = FileUtils.readFile("D://dictionary.txt");
        wordList.forEach(word-> TrieUtils.addTrieNode(word,root));
    }
    @Test
    public void commonWordTest(){
        for (int i=0;i<TEST_NUM;i++){
            String prefix = getPrefix(RANDOM.nextInt(5));
            if ("".equals(prefix)){
                continue;
            }
            System.out.println(prefix);
            Assert.assertEquals(TrieUtils.countPrefix(prefix,root),TrieUtils.findMatchWords(prefix,root).size());
        }
    }

    private String getPrefix(int length){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<length;i++){
            int temp = RANDOM.nextInt(2) % 2 == 0 ? 65 : 97;
            sb.append((char)(RANDOM.nextInt(26) + temp));
        }
        return sb.toString();
    }
}
