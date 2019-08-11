package module;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName module.TrieNode
 * @Description
 * @Author ljj
 * @Version V2.0.0
 * @Date 2019-08-10 22:48:53
 */
public class TrieNode {
    /** 有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数 **/
    private int num;
    /** 所有的儿子节点 **/
    private List<TrieNode> son;
    /** 是不是最后一个节点 **/
    private boolean isEnd;
    /** 节点的内容 **/
    private char val;

    public TrieNode()
    {
        num = 1;
        son = new ArrayList<>();
        isEnd = false;
    }

    public void increaseNum(int increment){
        this.num = num+increment;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<TrieNode> getSon() {
        return son;
    }

    public void setSon(List<TrieNode> son) {
        this.son = son;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }
}
