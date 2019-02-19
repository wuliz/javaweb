package com.wlz.mvc_collect.dao;

import java.util.List;

import com.wlz.mvc_collect.bean.Collect;

public interface CollectDao {
public void save(Collect c);
public void update(Collect c);
public List list();
public void delete(String[] str);
public Collect get(int id);
}
