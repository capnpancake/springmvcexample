package com.example.demo.services;

import com.example.demo.model.DomainObject;

import java.util.*;

public abstract class AbstractMapService {
    protected Map<Integer, DomainObject> domainMap;

    public AbstractMapService(){
        domainMap = new HashMap<>();
    }

    public List<DomainObject> listAll() { return new ArrayList<>(domainMap.values()); }

    public DomainObject getById(Integer id) { return domainMap.get(id); }

    public DomainObject saveOrUpdate(DomainObject domainObject) {
        if (domainObject != null){
            if (domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);

            return domainObject;
        } else { throw new RuntimeException("Object cannot be null!"); }
    }

    public void delete(Integer id) { domainMap.remove(id); }

    private Integer getNextKey() {
        if (domainMap.isEmpty()){ return 1; }
        return Collections.max(domainMap.keySet()) + 1;
    }

}
