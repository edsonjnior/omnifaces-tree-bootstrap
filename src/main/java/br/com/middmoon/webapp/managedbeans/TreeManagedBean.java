/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.middmoon.webapp.managedbeans;

import br.com.middmoon.webapp.models.ItemMenu;
import br.com.middmoon.webapp.services.ItemMenuService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.model.tree.ListTreeModel;
import org.omnifaces.model.tree.TreeModel;

/**
 *
 * @author junior
 */
@ViewScoped
@Named
public class TreeManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ItemMenuService menuService;

    private TreeModel<ItemMenu> tree;

    @PostConstruct
    public void init() {
        tree = new ListTreeModel<>();
        addRoots(tree, menuService.listAll());
    }

    private void addChildren(ItemMenu parent, TreeModel<ItemMenu> tree, List<ItemMenu> list) {
        list.stream()
                .filter(i -> i.getParent() != null && i.getParent().equals(parent))
                .forEach(i -> addChildren(i, tree.addChild(i), list));
    }

    private void addRoots(TreeModel<ItemMenu> tree, List<ItemMenu> list) {
        list.stream()
                .filter(i -> i.getParent() == null)
                .forEach(i -> addChildren(i, tree.addChild(i), list));
    }

    public TreeModel<ItemMenu> getTree() {
        return tree;
    }

    public void setTree(TreeModel<ItemMenu> tree) {
        this.tree = tree;
    }

}
