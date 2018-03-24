package com.maven.ifa;

import com.maven.entity.DispatchList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispatchListIfa extends JpaRepository<DispatchList,String> {
   /*@Query( value = "select * from dispatchlist where dep like %?1% ", nativeQuery = true)
    public List<DispatchList> getDispatchList(String d);*/

   public List<DispatchList> findAllByOrderByIdAsc();
   public List<DispatchList> findByPeopleContains(String name);

   public List<DispatchList> findByManagerContains(String name);

   public List<DispatchList> findByDepContains(String name);

  public List<DispatchList> findByManagerAndPeople(String manager,String people);

  public  DispatchList findOneById(String id);
}
