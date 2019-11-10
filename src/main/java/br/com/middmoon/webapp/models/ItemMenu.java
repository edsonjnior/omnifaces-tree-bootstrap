/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.middmoon.webapp.models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author junior
 */
public class ItemMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String description;
    private ItemMenu parent;

    public ItemMenu() {
    }

    public ItemMenu(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public ItemMenu(Long id, String description, ItemMenu parent) {
        this.id = id;
        this.description = description;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemMenu getParent() {
        return parent;
    }

    public void setParent(ItemMenu parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemMenu other = (ItemMenu) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemMenu{" + "id=" + id + ", description=" + description + ", parent=" + parent + '}';
    }

}
