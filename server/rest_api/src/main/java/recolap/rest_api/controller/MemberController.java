package recolap.rest_api.controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recolap.rest_api.model.Member;
import recolap.rest_api.model.Member2;
import recolap.rest_api.repository.MemberRepository;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

@RequestMapping("/member")
@RestController
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    /*
        @GetMapping("/test")
        public Member memberTest(){
            return new Member(0,"test","test","test","test","test","test","test","test","test","test",0.0,0);
        }*/
    /*
    @PostMapping("/insert") // CREATE
    public Member insert(){
        return memberRepository.save(
                new Member(0,"test","test","test","test","test","test","test","test","test","test",0.0,0)
        );
    }*/
    /*
    @PostMapping("/insert") // CREATE
    public Member insert(@RequestBody Map<String, String> map){
        return memberRepository.save(
                new Member(map.get("PRODUCT_NAME"),map.get("PRICE"),map.get("DISPLAY"),map.get("CPU_NAME"),map.get("RESOLUTION"),map.get("RAM"),map.get("STORAGE_SIZE"), map.get("WEIGHT") )
        );
    }*/

    @PostMapping("/insert") // CREATE
    public Member insert(@RequestBody Member mem){
        return memberRepository.save(mem);}

    /*
        @PostMapping("/insert") // CREATE
    public Member insert(@RequestBody Member mem){
        System.out.println(mem.getProduct_name());
        return memberRepository.save(
                new Member(mem.getProduct_name(),mem.getPrice(),mem.getDisplay(),mem.getCpu_name(),mem.getResolution(),mem.getRam(),mem.getStorage_size(),mem.getWeight()));
    }

     */
/*
    @PostMapping("/insert_list") // CREATE
    public List<Member> insert_list(@RequestBody JsonArray jsonArray){

        for(int j =0; j< jsonArray.size(); j++){
            JsonObject jobject = (JsonObject) jsonArray.get(j);
            memberRepository.saveAll(
            );
        }
        return null;
    }*/

    @PostMapping("/insert_list") // CREATE
    public List<Member> insert_list(@RequestBody List<Member> mems){

        return memberRepository.saveAll(mems);}


    @GetMapping("/select") // READ
    public List<Member> selectAll(){
        return memberRepository.findAll();
    }

    @GetMapping("/select/{id}") // READ
    public Member selectOne(@PathVariable("id") long id){
        return memberRepository.findById(id).orElse(null);
    }

    @PostMapping("/update/{id}") // UPDATE
    public Member updateOne(@PathVariable("id") long id, @RequestBody Map<String, String> map){
        System.out.println(id);
        System.out.println(map);

        Member member = memberRepository.findById(id).orElse(null);
        member.setProduct_name(map.get("PRODUCT_NAME"));
        member.setPrice(map.get("PRICE"));
        member.setDisplay(map.get("DISPLAY"));
        member.setCpu_name(map.get("CPU_NAME"));
        member.setResolution(map.get("RESOLUTION"));
        member.setRam(map.get("RAM"));
        member.setStorage_size(map.get("STORAGE_SIZE"));
        member.setWeight(map.get("WEIGHT"));

        return memberRepository.save(member);
    }

    @PostMapping("/delete/{id}") // DELETE
    public String deleteOne(@PathVariable("id") long id){
        memberRepository.deleteById(id);
        return "삭제 완료";
    }

    int intParser(String age){
        try{
            return Integer.parseInt(age);
        } catch(ClassCastException e){
            e.printStackTrace();
            return 0;
        }
    }
}
