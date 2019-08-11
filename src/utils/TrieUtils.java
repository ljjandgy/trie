package utils;


import module.TrieNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        TrieNode cur = root;
        if(root==null){
            return;
        }
        for(int i=0;i<word.length();i++){
            TrieNode child=cur.getNodeMap().get(word.charAt(i));
            if(child==null){
                TrieNode node=new TrieNode(word.charAt(i),1,new HashMap<>());
                cur.getNodeMap().put(word.charAt(i),node);
                cur=node;
            }else{
                cur=child;
                cur.increaseNum();
            }
            //记录这个地方节点是一个完整的单词
            if (i==word.length()-1){
                cur.setIsEnd(Boolean.TRUE);
            }
        }
    }

    /**
     * 计算前缀数量
     * @param prefix 前缀内容
     * @param curNode 查询的起始节点
     * @return 前缀数量
     */
    public static int countPrefix(String prefix,TrieNode curNode)
    {
        if(curNode==null){
            return 0;
        }
        for(int i=0;i<prefix.length();i++){
            TrieNode child=curNode.getNodeMap().get(prefix.charAt(i));
            if(child==null){
                return 0;
            }else {
                curNode = child;
            }
        }
        return curNode.getNum();
    }
    /**
     * 获取前缀匹配的单词
     * @param prefix 前缀
     * @param curNode 查询的开始节点
     */
    public static List<String> findMatchWords(String prefix, TrieNode curNode) {
        List<String> wordList = new ArrayList<>();
        if(curNode==null){
            return wordList;
        }
        for(int i=0;i<prefix.length();i++){
            TrieNode child=curNode.getNodeMap().get(prefix.charAt(i));
            if(child==null){
                return wordList;
            }else {
                curNode = child;
            }
        }
        //如果前缀为一个完整单词，就添加进去
        if (curNode.getIsEnd()){
            wordList.add(prefix);
        }
        getWords(wordList,curNode.getNodeMap(),prefix);
        return wordList;
    }

    /**
     * 获取所有匹配的单词
     * @param wordList 单词集合
     * @param nodeMap 节点所包含的所有子节点
     * @param prefix 前缀字符
     */
    private static void getWords(List<String> wordList, Map<Character, TrieNode> nodeMap,String prefix){
        //当前缀匹配完后
        nodeMap.forEach((wordChar,node)->{
            //还有子节点时
            if (node.getNodeMap()!=null&&node.getNodeMap().size()>0){
                //存在完整单词时
                if (node.getIsEnd()&&wordList.size()<10){
                    wordList.add(prefix+wordChar);
                }
                getWords(wordList,node.getNodeMap(),prefix+wordChar);
            }else{
                //没有子节点时,就是一个完整单词了
                if (wordList.size()<10){
                    wordList.add(prefix+wordChar);
                }
            }
        });
    }



}
