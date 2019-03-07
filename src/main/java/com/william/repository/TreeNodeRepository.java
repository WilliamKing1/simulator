package com.william.repository;

import com.william.entity.TreeNode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeNodeRepository extends CrudRepository<TreeNode, String> {

    public TreeNode findByName(String name);

    public List<TreeNode> findByLevel(Integer level);
    public TreeNode findNodeById(String serviceId);

}
