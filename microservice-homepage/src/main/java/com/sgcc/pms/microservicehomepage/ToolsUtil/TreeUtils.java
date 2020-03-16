package com.sgcc.pms.microservicehomepage.ToolsUtil;

import com.sgcc.pms.microservicehomepage.bean.HomePageMenuUtil;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    // 入口方法
    public static List<HomePageMenuUtil> getTree(List<HomePageMenuUtil> nodeList) {
        List<HomePageMenuUtil> list = new ArrayList<HomePageMenuUtil>();
        // 遍历节点列表
        for (HomePageMenuUtil node : nodeList) {
            if (node.getParentMenuId().equals("-1")) {
                // parentID为-1（根节点）作为入口
                node.setChildren( getChildrenNode(node.getMenuid(), nodeList));
                list.add(node);
            }
        }
        return list;
    }

    // 获取子节点的递归方法
    private static List<HomePageMenuUtil> getChildrenNode(int id, List<HomePageMenuUtil> nodeList) {
        List<HomePageMenuUtil> list = new ArrayList<HomePageMenuUtil>();
        for (HomePageMenuUtil node : nodeList) {
            if (node.getParentMenuId().equals(id+"")) {
                // 递归获取子节点
                node.setChildren(getChildrenNode(node.getMenuid(), nodeList));
                list.add(node);
            }
        }
        return list;
    }
}
