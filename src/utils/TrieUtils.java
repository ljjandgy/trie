package utils;


import module.TrieNode;

/**
 * @ClassName TrieUtils
 * @Description 词典树工具类
 * @Author ljj
 * @Version V2.0.0
 * @Date 2019-08-10 19:09:24
 */
public class TrieUtils {
    /**
     * 新增字典树节点
     * @param word 单词
     * @param root 根节点
     */
    public static void addTrieNode(String word, TrieNode root){
        if (word == null || word.length() == 0)
        {
            return;
        }
        //将目标单词转换为字符数组
        char[] letters = word.toCharArray();
        for (int i = 0, len = word.length(); i < len; i++)
        {
            int pos = letters[i] - 'a';
            //如果当前节点的儿子节点中没有该字符，则构建一个TrieNode并复值该字符
            if (root.getSon().isEmpty())
            {
                root.getSon().set(pos,new TrieNode());
                root.getSon().get(pos).setVal(letters[i]);
            }
            else   //如果已经存在，则将由根至该儿子节点组成的字符串模式出现的次数+1
            {
                root.getSon().get(pos).increaseNum(1);
            }
            root = root.getSon().get(pos);
        }
        root.setEnd(true);
    }


}
