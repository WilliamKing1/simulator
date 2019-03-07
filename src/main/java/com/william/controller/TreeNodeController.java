package com.william.controller;

import com.william.entity.TreeNode;
import com.william.pojo.Node;
import com.william.pojo.ServiceDetails;
import com.william.service.TreeNodeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("GCT CBK Simulator API")
@RequestMapping("/api/v1/simulator/")
public class TreeNodeController {
    @Autowired
    private TreeNodeService treeNodeService;

    @ApiOperation(value = "init the market and env node ",notes="init the basic tree")
    @GetMapping(value="/init")
    public void init(){
        treeNodeService.init();

    }


    @ApiOperation(value = "get the details based on the service id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId",value = "service Id",dataType = "String",paramType = "path",example = "**")
    })
    @ApiResponses({
            @ApiResponse(code=400,message = ""),
            @ApiResponse(code=404,message="No matched  node found")})
    @GetMapping(value = "/service/{serviceId}")
    public TreeNode search (@PathVariable String serviceId){

        return null;

    }

    @ApiOperation(value = "return all the services by tree mode")
    @ApiResponses({
            @ApiResponse(code=200,message = ""),
            @ApiResponse(code=404,message="No matched  node found")})
    @GetMapping("/services")
    public List<Node>  getTree(){


        return  treeNodeService.getTree();

    }
    @ApiOperation(value = "Add Service")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "details",value = "details about the new service",dataType = "ServiceDetails",paramType = "body",example = "**")
    })
    @ApiResponses({
            @ApiResponse(code=400,message = "incorrect request "),
            @ApiResponse(code=404,message="failed to add the new service")})
    @PutMapping("/service")
    public Object addNewService(@RequestBody ServiceDetails details){

         treeNodeService.addNewService(details);
         return null;

    }
    @ApiOperation(value = "Add new version to  the serviceid ")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId",value = "serviceId",dataType = "String",paramType = "path",example = "**"),
            @ApiImplicitParam(name = "details",value = "",dataType = "ServiceDetails",paramType = "body",example = "**")
    })
    @ApiResponses({
            @ApiResponse(code=400,message = "incorrect request "),
            @ApiResponse(code=404,message="invalid service id")})
    @PatchMapping("/service/{serviceId}")
    public Object addNewVersion(@PathVariable String serviceId,@RequestBody ServiceDetails details){
        treeNodeService.addNewVersion(details);
        return null;

    }
    @ApiOperation(value = "invoke service based on the service request ")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceid",value = "node id",dataType = "String",paramType = "path",example = "**"),
            @ApiImplicitParam(name = "requestDetails",value = "",dataType = "String",paramType = "body",example = "**")
    })
    @ApiResponses({
            @ApiResponse(code=400,message = "incorrect request"),
            @ApiResponse(code=404,message="invalid service id ")})
    @GetMapping("/service/{serviceid}/invoke")

    public Object invoke(@PathVariable String serviceId,@RequestBody String requestDetails){
        return null;
    }


}
