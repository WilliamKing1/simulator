package com.william.dao.imp;

import com.william.dao.TreeNodeDao;
import com.william.entity.TreeNode;
import com.william.repository.TreeNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("treeNodeDao")
public class TreeNodeDaoImp implements TreeNodeDao {
    @Autowired
    private TreeNodeRepository treeNodeRepository;
    public List<TreeNode> getTree(){

        List<TreeNode> all = (List<TreeNode>) treeNodeRepository.findByLevel(new Integer(0));
        return all;
    }

    public TreeNode getTreeNodeByServiceId(String  serviceId){

        TreeNode node = treeNodeRepository.findNodeById(serviceId);
        return node;
    }
    public void addTreeNode(TreeNode treeNode){

        treeNodeRepository.save(treeNode);
    }
}
