package com.umran.springtutor.springApi;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CycleService {
    private List<CycleDecs> top =new ArrayList<>(  Arrays.asList(
            new CycleDecs(1,"gundelik","bisim","cocuk","23",2010),
            new CycleDecs(2,"dag","scoda","spor","12",2016),
            new CycleDecs(3,"gezi","camarro","yaris","31",2000)
    ));

    public List<CycleDecs> getTop() {

        return top;

    }

    public CycleDecs getById(int id)
    {

      return top.stream().filter(top-> top.equals(id)).findFirst().get();

    }


    public void addCycle(CycleDecs cycledesc) {

         top.add(cycledesc);
    }

    public void updateCycle(int id, CycleDecs cycledesc) {

       for (int i=0;i < top.size();i++)
       {
           CycleDecs c = top.get(i);
           if (c.getId()==id){
               top.set(i,cycledesc);

               return;

           }
       }
    }

    public void deleteCycle(int id) {

        for (int i=0; i< top.size();i++)
        {
            CycleDecs c = top.get(i);
            if (c.getId()== id)
            {
                top.remove(i);

            }
        }


    }
}

