package com.ifpb.mongodb.view;

import com.ifpb.mongodb.dao.PessoaDao;
import com.ifpb.mongodb.dao.VendaDao;
import com.ifpb.mongodb.model.ItemVenda;
import com.ifpb.mongodb.model.Pessoa;
import com.ifpb.mongodb.model.Produto;
import com.ifpb.mongodb.model.Venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

//        PessoaDao dao = new PessoaDao();
//
//        dao.salvar(new Pessoa("222.222.222-02", "Maria", 19));
//
//        System.out.println(dao.listar());
//
//        System.out.println(dao.buscarPorCpf("XXX"));
//
//        dao.atualizar(new Pessoa("111.111.111-01",
//                "João Paulo", 22));

        VendaDao daoVenda = new VendaDao();

        System.out.println(daoVenda.listar());

//        Produto produto1 = new Produto(1, "Teclado", 30);
//        Produto produto2 = new Produto(2, "Mouse", 20);
          Produto produto3 = new Produto(3, "MousePad", 50);
//
//        ItemVenda item1 = new ItemVenda(produto1, 1);
//        ItemVenda item2 = new ItemVenda(produto2, 2);
          ItemVenda item3 = new ItemVenda(produto3, 1);
//
//        List<ItemVenda> itens = new ArrayList<>();
//        itens.add(item1);
//        itens.add(item2);
//
//        Venda venda = new Venda(1, itens, LocalDateTime.now());
//
//        dao.salvar(venda);
        System.out.println(daoVenda.atualizarVenda(1, item3));
//        System.out.println(daoVenda.buscaPorCodigo(1));
//        System.out.println(daoVenda.deletarPorCodigo(1));
    }
}
