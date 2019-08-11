package module;

import java.util.Map;

/**
 * @ClassName module.TrieNode
 * @Description
 * @Author ljj
 * @Version V2.0.0
 * @Date 2019-08-10 22:48:53
 */
public class TrieNode {
    /** 单词包含的单字符 **/
    private char wordChar;
    /** 单词出现的次数 **/
    private int num;
    /** 包含的所有子节点 **/
    private Map<Character, TrieNode> nodeMap;
    /** 是否是单词的最后一个节点 **/
    private Boolean isEnd;

    public TrieNode(char wordChar, int num, Map<Character, TrieNode> nodeMap) {
        this.wordChar = wordChar;
        this.num = num;
        this.nodeMap = nodeMap;
        this.isEnd = false;
    }

    /**
     * 增加num
     */
    public void increaseNum(){
        this.num++;
    }

    public char getWordChar() {
        return wordChar;
    }

    public void setWordChar(char wordChar) {
        this.wordChar = wordChar;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Map<Character, TrieNode> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<Character, TrieNode> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public Boolean getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Boolean end) {
        this.isEnd = end;
    }
}
