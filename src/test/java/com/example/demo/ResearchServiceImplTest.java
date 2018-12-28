package com.example.demo;

import com.example.demo.pojo.Research;
import com.example.demo.services.Impl.ResearchServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ResearchServiceImplTest extends DemoApplicationTests {

    @Autowired
    ResearchServiceImpl researchService=null;


    @Test
    public void testInsert(){
        Research research=new Research();

        research.setResearchTitle("New Test Research");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String start="2018-12-25";
        String end="2019-01-01";

        Date startDate = null;
        Date endDate=null;

        try {
            startDate=sdf.parse(start);
            endDate=sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        research.setResearchStart(startDate);
        research.setResearchEnd(endDate);
        research.setResearchGuest(true);

        try {
            Assert.assertSame("Not ok",1, researchService.insert(research));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect(){

        String keyword="test";

        List<Research> list= researchService.getResearchByTitle(keyword,null);
        System.out.println(String.format("ListSize=%d",list.size()));

        for(Research research :list ){
            System.out.println(String.format("ID:%d\tTitle:%s\tStart:%tF\tEnd:%tF",research.getResearchId(),
                    research.getResearchTitle(),research.getResearchStart(),research.getResearchEnd()));
        }

    }

    @Test
    public void testUpdate(){
        try {
            Research research=researchService.getResearchById(5);

            System.out.println(String.format("ID:%d\tTitle:%s\tStart:%tF\tEnd:%tF",research.getResearchId(),
                    research.getResearchTitle(),research.getResearchStart(),research.getResearchEnd()));

            research.setResearchEnd(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-31"));

            researchService.update(research);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){

    }


}
