package com.william.dao;

import com.william.entity.TreeNode;

import java.util.List;

public interface TreeNodeDao {
   List<TreeNode> getTree();

   TreeNode getTreeNodeByServiceId(String  serviceId);
   void addTreeNode(TreeNode treeNode);
}
