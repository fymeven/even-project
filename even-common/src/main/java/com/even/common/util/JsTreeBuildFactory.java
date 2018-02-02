package com.even.common.util;

import com.even.model.JsTree;

import java.util.ArrayList;
import java.util.List;

public class JsTreeBuildFactory {
	public enum RootEnum{
		AUTH(0L,"本系统"),
		DEPT(0L,"xx公司");

		private Long id;
		private String text;

		RootEnum(Long id, String text) {
			this.id = id;
			this.text = text;
		}

		public Long getId() {
			return id;
		}

		public String getText() {
			return text;
		}
	}


	public static JsTree buildRoot(List<JsTree> nodes,RootEnum rootEnum) {
		if (nodes == null) {
			return null;
		}
		List<JsTree> topNodes = new ArrayList<>();
		for (JsTree children : nodes) {
			String pid = children.getParentId();
			if (pid == null || String.valueOf(rootEnum.getId()).equals(pid)) {
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
		root.setId(String.valueOf(rootEnum.getId()));
		root.setChildren(topNodes);
		root.setText(rootEnum.getText());
		root.getState().put("opened",true);
		return root;
	}

	public static List<JsTree> buildList(List<JsTree> nodes,RootEnum rootEnum) {
		if (nodes == null) {
			return null;
		}
		List<JsTree> topNodes = new ArrayList<>();
		for (JsTree children : nodes) {
			String pid = children.getParentId();
			if (pid == null || String.valueOf(rootEnum.getId()).equals(pid)) {
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