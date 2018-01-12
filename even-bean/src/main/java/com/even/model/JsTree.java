package com.even.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by even on 2017/12/27.
 */
public class JsTree implements Serializable{
    /**
     * 节点id
     */
    private String id;
    /**
     * 父节点id
     */
    private String parentId;
    /**
     * 节点文本
     */
    private String text;
    /**
     * 节点图标
     */
    private String icon;
    /**
     * 节点额外属性
     */
    private Map<String,Object> attr=new HashMap<>();
    /**
     * 节点状态信息
     * opened  selected  disabled
     */
    private Map<String,Object> state=new HashMap<>();
    /**
     * 子节点列表
     */
    private List<JsTree> children=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Map<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Object> attr) {
        this.attr = attr;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }

    public List<JsTree> getChildren() {
        return children;
    }

    public void setChildren(List<JsTree> children) {
        this.children = children;
    }
}
