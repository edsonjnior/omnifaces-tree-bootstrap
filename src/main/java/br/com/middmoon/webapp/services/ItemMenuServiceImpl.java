/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.middmoon.webapp.services;

import br.com.middmoon.webapp.models.ItemMenu;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author junior
 */
@Stateless
public class ItemMenuServiceImpl implements ItemMenuService {

    private static final List<ItemMenu> ITEMS;

    static {
        ItemMenu item1 = new ItemMenu(1L, "Item 01");
        ItemMenu item2 = new ItemMenu(2L, "Item 02");
        ItemMenu item3 = new ItemMenu(3L, "Item 03");

        ItemMenu item11 = new ItemMenu(11L, "Item 01 - Item 01_01", item1);
        ItemMenu item12 = new ItemMenu(12L, "Item 01 - Item 01_02", item1);
        ItemMenu item21 = new ItemMenu(21L, "Item 02 - Item 02_01", item2);
        ItemMenu item22 = new ItemMenu(22L, "Item 02 - Item 02_02", item2);

        ItemMenu item111 = new ItemMenu(111L, "Item 01 - Item 01_01 - Item 01_01_01", item11);
        ItemMenu item112 = new ItemMenu(112L, "Item 01 - Item 01_01 - Item 01_01_02", item11);

        ITEMS = Arrays.asList(item1, item2, item3, item11, item12, item21, item22, item111, item112);
    }

    @Override
    public List<ItemMenu> listAll() {
        return ITEMS;
    }

}
