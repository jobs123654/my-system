package com.maven.ifa;

import com.maven.entity.DispatchList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispatchListIfa extends JpaRepository<DispatchList,String> {
   @Query( value = "select * from dispatchlist where dep like %?1% ", nativeQuery = true)
    public List<DispatchList> getDispatchList(String d);
}
