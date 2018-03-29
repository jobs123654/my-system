package com.Tool;

import java.util.List;

public class Page <T>{
  private int current=1;
  
  private int totalPage;
  
  private int totalSize;
  
  private int offset;
  
  private int size;//每一页的记录数
  
  private int length;//progressbar
  
  private int start;
  
  private int stop;
  
  /**
 * @return the start
 */
public int getStart() {
	return start;
}

/**
 * @param start the start to set
 */
public void setStart(int start) {
	this.start = start;
}

/**
 * @return the stop
 */
public int getStop() {
	return stop;
}

/**
 * @param stop the stop to set
 */
public void setStop(int stop) {
	this.stop = stop;
}

private List<T> source;
  
  
  
  private List<T> result;

public Page(int c, int size, List<T> source) {
	super();
	this.size = size;
	this.source = source;
	this.current=c;
	offset=(current-1)*size;
	
    totalSize=source.size();
    
    totalPage=totalSize%size==0?totalSize/size:(totalSize/size)+1;
    
    size=size*current>totalSize?totalSize:size*current;
    
    if(current<=0)
	{
		current=1;
	}
	if(current>totalPage)
	{
		current=totalPage;
	}
    result=source.subList(offset, size);
    
    start=c;
    
    stop=c+3>totalPage?totalPage:c+4;
    
    
    
}

/**
 * @return the current
 */
public int getCurrent() {
	return current;
}

/**
 * @param current the current to set
 */
public void setCurrent(int current) {
	this.current = current;
}

/**
 * @return the totalPage
 */
public int getTotalPage() {
	return totalPage;
}

/**
 * @param totalPage the totalPage to set
 */
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

/**
 * @return the totalSize
 */
public int getTotalSize() {
	return totalSize;
}

/**
 * @param totalSize the totalSize to set
 */
public void setTotalSize(int totalSize) {
	this.totalSize = totalSize;
}

/**
 * @return the size
 */
public int getSize() {
	return size;
}

/**
 * @param size the size to set
 */
public void setSize(int size) {
	this.size = size;
}

/**
 * @return the page
 */


/**
 * @return the source
 */
public List<T> getSource() {
	return source;
}

/**
 * @param source the source to set
 */
public void setSource(List<T> source) {
	this.source = source;
}

/**
 * @return the result
 */
public List<T> getResult() {
	return result;
}

/**
 * @param result the result to set
 */
public void setResult(List<T> result) {
	this.result = result;
}
  
  
}
