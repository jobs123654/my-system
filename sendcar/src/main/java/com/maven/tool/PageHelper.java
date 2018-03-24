package com.maven.tool;

import java.util.List;

public class PageHelper<T> {
    private int current=1;//当前页

    private  int pagesize;//每页的记录数

    private  int totalPage;//总页数

    private int totalSize;//总的记录数

    private  int offset=0;//偏移

    private int index;//目标索引

    private List<T> list;

    private  List<T> result;

    public List<T> getResult() {
        int index=pagesize*current>totalSize?totalSize:pagesize*current;
    result=list.subList(getOffset(), index);
        return result;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public  PageHelper(int current, int pagesize, List<T> list)
    {
        this.current=current;
        this.pagesize=pagesize;
        this.list=list;
        this.totalSize=list.size();
        //处理逻辑


        totalPage=totalSize/pagesize;
        if(current<1){
            current=1;
        }
        if(totalPage>0&&current>totalPage)
        {
            current=totalPage;
        }
        System.out.println(totalPage);
        if(list.size()%pagesize!=0)
        {
            totalPage+=1;
        }

        offset=pagesize*(current-1);

        index=pagesize*current>totalSize?totalSize:pagesize*current;



        result=list.subList(offset, index);


    }



    public int getCurrent() {

        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }



    public int getTotalSize() {
        return list.size();
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

//获取偏移
    public int getOffset() {
        return pagesize*(current-1);
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
