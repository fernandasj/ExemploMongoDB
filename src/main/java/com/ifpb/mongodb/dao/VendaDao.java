package com.ifpb.mongodb.dao;

import com.ifpb.mongodb.database.MongoConnectionPojo;
import com.ifpb.mongodb.model.ItemVenda;
import com.ifpb.mongodb.model.Venda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class VendaDao {

    private MongoCollection collection;

    public VendaDao(){
        collection = new MongoConnectionPojo()
                .getCollection("Venda", Venda.class);
        collection.createIndex(new Document("codigo", 1), new IndexOptions().unique(true));
    }

    public void salvar(Venda venda){
        collection.insertOne(venda);
    }

    public List<Venda> listar(){
        MongoCursor cursor = collection.find().iterator();

        List<Venda> vendas = new ArrayList<>();

        while (cursor.hasNext()){
            vendas.add((Venda) cursor.next());
        }

        return vendas;
    }
    
    public Venda buscaPorCodigo(int codigo){
        MongoCursor cursor = collection.find(eq("codigo", codigo)).iterator();

        return (Venda) cursor.next();
    }
    
    public boolean deletarPorCodigo(int codigo){
        DeleteResult result = collection.deleteOne(eq("codigo", codigo));
        
        return result.getDeletedCount()>0;
    }
    
    public boolean atualizarVenda(int codVenda, ItemVenda item){        
        UpdateResult result = collection.updateOne(
                eq("codigo", codVenda),Updates.addToSet("itens", item));
        
        return result.getModifiedCount()>0;
    }
}
