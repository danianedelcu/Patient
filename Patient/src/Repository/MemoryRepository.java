package Repository;
import Domain.Identifiable;
import java.lang.Exception;

import java.util.HashMap;
import Repository.Repository;

import javax.swing.*;

public class MemoryRepository <ID,T extends Identifiable<ID>> implements Repository<T, ID>
{
    //private HashMap<ID, T> repository;
    private  HashMap<ID, T> data = new HashMap<ID,T>();


    @Override
    public void add(T object) throws Exception {
            if(data.containsKey(object.getId())){
                throw new Exception("The object exists.");
            }
            data.put(object.getId(), object);
        }

    @Override
    public void delete(ID id) throws Exception{
        if(!data.containsKey(id)) {
            throw new Exception("The object does not exist");
        }
        data.remove(id);
    }
    @Override
    public void update(ID id, T object) throws Exception {
        if(!data.containsKey(id)) {
            throw new Exception("The object does not exist");
        }
        data.put(id, object);
    }

    @Override
    public T findById(ID id) throws Exception{
        if(!data.containsKey(id)) {
            throw new Exception("The object does not exist");}

        return data.get(id);
    }

    @Override
    public Iterable<T> getAll(){
        return data.values();
    }



}
