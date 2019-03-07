package com.william.controller;

import com.william.entity.SimulatorHistory;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/simulator")
public class HistoryController {

    @ApiOperation(value = "list all of the history recently")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start",value = "start",dataType = "String",paramType = "query",example = "**"),
            @ApiImplicitParam(name = "length",value = "size",dataType = "String",paramType = "query",example = "**")
    })
    @ApiResponses({})
    @GetMapping(value = "/history/logs")
    public List<SimulatorHistory> all (@RequestParam String start, @RequestParam String length){

        return null;

    }
    @ApiOperation(value = "list all of the history for target service")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId",value = "serviceId",dataType = "String",paramType = "path",example = "**"),
            @ApiImplicitParam(name = "start",value = "start",dataType = "String",paramType = "query",example = "**"),
            @ApiImplicitParam(name = "length",value = "size",dataType = "String",paramType = "query",example = "**")
    })
    @ApiResponses({})
    @GetMapping(value = "/history/{serviceId/logs")
    public List<SimulatorHistory> getLogByServiceId (@PathVariable String serviceId,@RequestParam String start, @RequestParam String length){

        return null;

    }
    @ApiOperation(value = "accept or reject the result")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "logid",value = "logid",dataType = "String",paramType = "path",example = "**"),
            @ApiImplicitParam(name = "isAccepted",value = "true",dataType = "boolean",paramType = "query",example = "**")})
    @ApiResponses({})
    @PutMapping(value = "/history/{logId}")
    public List<SimulatorHistory> accept (@PathVariable String logId, @RequestParam boolean isAccepted){

        return null;

    }
}
