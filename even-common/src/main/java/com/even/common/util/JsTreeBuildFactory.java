package com.even.common.util;

import com.even.io.sysAuth.enums.SysAuthEnum;
import com.even.model.JsTree;

import java.util.ArrayList;
import java.util.List;

public class JsTreeBuildFactory {

	public static JsTree buildRoot(List<JsTree> nodes) {
		if (nodes == null) {
			return null;
		}
		List<JsTree> topNodes = new ArrayList<>();
		for (JsTree children : nodes) {
			String pid = children.getParentId();
			if (pid == null || String.valueOf(SysAuthEnum.ROOT_ID).equals(pid)) {
				topNodes.add(children);
				continue;
			}
			for (JsTree parent : nodes) {
				String id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					continue;
				}
			}
		}

		JsTree root = new JsTree();
		if (topNodes.size() == 1) {
			root = topNodes.get(0);
		} else {
			root.setId(String.valueOf(SysAuthEnum.ROOT_ID));
			root.setChildren(topNodes);
			root.setText(SysAuthEnum.ROOT_NAME);
			root.getState().put("opened",true);
            root.getState().put("checked",true);
		}
		return root;
	}

	public static List<JsTree> buildList(List<JsTree> nodes) {
		if (nodes == null) {
			return null;
		}
		List<JsTree> topNodes = new ArrayList<>();
		for (JsTree children : nodes) {
			String pid = children.getParentId();
			if (pid == null || String.valueOf(SysAuthEnum.ROOT_ID).equals(pid)) {
				topNodes.add(children);
				continue;
			}
			for (JsTree parent : nodes) {
				String id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					continue;
				}
			}
		}
		return topNodes;
	}
}