package com.william.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class Node {
    String id;
    String parent;
    String text;
    State state=new State();
    @JsonProperty("li_attr")
    LiAttr li_attr=new LiAttr();
    public void setClosed(){
        state.opened=false;
    }
    public void setLeafType(){
        li_attr.type="{'selected':true,type':'file'}";
    }

}

class State{
    public  boolean opened=false;
}

class LiAttr{
    @JsonProperty("data-jstree")
   public String type="";

}
