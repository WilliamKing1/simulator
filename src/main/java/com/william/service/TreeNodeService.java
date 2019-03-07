package com.william.service;

import com.william.dao.TreeNodeDao;
import com.william.entity.TreeNode;
import com.william.pojo.Node;
import com.william.pojo.ServiceDetails;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("treeNodeService")
@Slf4j
@ToString
public class TreeNodeService {
    @Autowired
   private TreeNodeDao treeNodeDao;

    public void init(){
        LocalDateTime now=LocalDateTime.now();
        TreeNode market = new TreeNode();
        market.setName("CPB ASIA");
        market.setParent(null);
        market.setCreateId("SYS");
        market.setCreateTimeStamp(now);
        market.setLastUpdateId("SYS");
        market.setLastUpdateTimeStamp(now);
        market.setDescription("CPB ASIA");
        market.setLevel(0);
        market.setSequence(1);

        treeNodeDao.addTreeNode(market);


        TreeNode env = new TreeNode();
        env.setName("SIT");
        env.setParent(market);
        env.setCreateId("SYS");
        env.setCreateTimeStamp(now);
        env.setLastUpdateId("SYS");
        env.setLastUpdateTimeStamp(now);
        env.setDescription("SIT");
        env.setLevel(1);
        env.setSequence(1);
        treeNodeDao.addTreeNode(env);







    }
    public void addNewService(ServiceDetails details){

        String parentId=details.getParentId();
        String serviceName=details.getServiceName();
        String requestSchema=details.getRequestSchema();
        String responseSchema=details.getResponseSchema();
        String description=details.getDescription();
        String serviceType=details.getType();
        String version=details.getVersion();

        LocalDateTime now=LocalDateTime.now();
        TreeNode newService = new TreeNode();
        TreeNode parentNode = treeNodeDao.getTreeNodeByServiceId(parentId);
        newService.setName(serviceName);
        newService.setParent(parentNode);
        newService.setCreateId("SYS");
        newService.setCreateTimeStamp(now);
        newService.setLastUpdateId("SYS");
        newService.setLastUpdateTimeStamp(now);
        newService.setDescription(description);
        newService.setLevel(parentNode.getLevel()+1);
        newService.setSequence(parentNode.getChildren().size()+1);
        newService.setServiceType(serviceType);
        treeNodeDao.addTreeNode(newService);

        TreeNode newVersion = new TreeNode();
        String defaultVersion = StringUtils.isNotEmpty(version) ? version : "0.0.1";
        newVersion.setName(defaultVersion);
        newVersion.setParent(newService);
        newVersion.setCreateId("SYS");
        newVersion.setCreateTimeStamp(now);
        newVersion.setLastUpdateId("SYS");
        newVersion.setLastUpdateTimeStamp(now);
        newVersion.setDescription("");
        newVersion.setLevel(parentNode.getLevel()+1);
        newVersion.setSequence(1);
        newVersion.setRequestUri(requestSchema);
        newVersion.setResponseUri(responseSchema);
        treeNodeDao.addTreeNode(newVersion);



    }

    public void addNewVersion(ServiceDetails details){

        String parentId=details.getParentId();
        String serviceName=details.getServiceName();
        String requestSchema=details.getRequestSchema();
        String responseSchema=details.getResponseSchema();
        String description=details.getDescription();
        String serviceType=details.getType();
        String version=details.getVersion();

        LocalDateTime now=LocalDateTime.now();
        TreeNode serviceNode = treeNodeDao.getTreeNodeByServiceId(parentId);
        TreeNode newVersion = new TreeNode();
        String defaultVersion = StringUtils.isNotEmpty(version) ? version : "0.0.1";
        newVersion.setName(defaultVersion);
        newVersion.setParent(serviceNode);
        newVersion.setCreateId("SYS");
        newVersion.setCreateTimeStamp(now);
        newVersion.setLastUpdateId("SYS");
        newVersion.setLastUpdateTimeStamp(now);
        newVersion.setDescription(description);
        newVersion.setLevel(serviceNode.getLevel()+1);
        newVersion.setSequence(1);
        newVersion.setRequestUri(requestSchema);
        newVersion.setResponseUri(responseSchema);
        treeNodeDao.addTreeNode(newVersion);



    }

    public List<Node>   getTree(){
        List<TreeNode> treeNodeList = treeNodeDao.getTree();
        List<Node> tree=new ArrayList<>();
        for(TreeNode node:treeNodeList){
            /*Node root = new Node();
            root.setId(node.getId());
            root.setParent("#");
            root.setText(node.getName());

            tree.add(root);*/
            convertTreeNode(node,tree);


        }

        return tree;
    }
    public void convertTreeNode(TreeNode treeNode,List<Node> nodeList){
        if(treeNode.getChildren().size()==0 ){
            Node childNode = new Node();
            childNode.setId(treeNode.getId());
            childNode.setParent(treeNode.getParent().getId());
            childNode.setText(treeNode.getName());
            childNode.setLeafType();
            nodeList.add(childNode);
            //this is version Node

        }else{
            Node childNode = new Node();
            childNode.setId(treeNode.getId());
            if(treeNode.getParent()==null){
                childNode.setParent("#");
            }else {
                childNode.setParent(treeNode.getParent().getId());
            }
            childNode.setText(treeNode.getName());
            nodeList.add(childNode);
            for(TreeNode temp:treeNode.getChildren()){
                 convertTreeNode(temp,nodeList);
            }
        }
    }
    public TreeNode  search(String serviceId){
        TreeNode node = treeNodeDao.getTreeNodeByServiceId(serviceId);

        return node;

    }

}
