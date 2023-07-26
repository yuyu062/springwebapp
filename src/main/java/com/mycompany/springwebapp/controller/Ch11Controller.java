package com.mycompany.springwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch11City;
import com.mycompany.springwebapp.dto.Ch11Member;
import com.mycompany.springwebapp.dto.Ch11Skill;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch11")
public class Ch11Controller {
   
   @RequestMapping("/content")
   public String content() {
      return "ch11/content";
   }
   
   @GetMapping("/form1")
   public String form1(@ModelAttribute("member") Ch11Member member) {
	   member.setMid("summer");
	   member.setMname("홍길동");
	   member.setMpassword("12345");
	   member.setMnation("한국");
	   return "ch11/form1";
   }
   @PostMapping("/form1")
   public String handleForm1(@ModelAttribute("member") Ch11Member member) {
	   log.info(member.toString());
	   return "redirect:/ch11/content";
   }
   
   @GetMapping("/form2")
   public String form2(@ModelAttribute("member") Ch11Member member, Model model) {
	   //드롭다운리스트(<select>)의 항목을 추가할 목적
	   List<String> typeList = new ArrayList<>();
	   typeList.add("일반회원");
	   typeList.add("기업회원");
	   typeList.add("헤드헌터회원");
	   model.addAttribute("typeList", typeList); //request객체에 저장
	   //기본값을 설정(member가 기본적으로 기업회원이 들어가있으므로 기업회원이 디폴트값으로 selected)
	   member.setMtype("기업회원");
	   
	   List<String> jobList = new ArrayList<>();
	   jobList.add("학생");
	   jobList.add("개발자");
	   jobList.add("디자이너");
	   model.addAttribute("jobList", jobList); //request객체에 저장
	   
	   //code와 value값이 다를경우 dto 객체에 두가지 필드값을 선언 후 각각 저장
	   List<Ch11City> cityList = new ArrayList<>();
	   cityList.add(new Ch11City(1, "서울"));
	   cityList.add(new Ch11City(2, "부산"));
	   cityList.add(new Ch11City(3, "제주"));
	   model.addAttribute("cityList", cityList);
	   member.setMcity(3);
	   return "ch11/form2";
   }
   
   @PostMapping("/form2")
   public String handleForm2(@ModelAttribute("member") Ch11Member member) {
	   log.info(member.toString());
	   return "redirect:/ch11/content";
   }
   
   @GetMapping("/form3")
   public String form3(@ModelAttribute("member") Ch11Member member, Model model) {
	  List<String> languageList = new ArrayList<>();
	  languageList.add("C");
	  languageList.add("Pythod");
	  languageList.add("Java");
	  languageList.add("JavaScript");
	  languageList.add("HTML");
	  model.addAttribute("languageList", languageList);
	  member.setMlanguage(new String[] {"Java", "HTML"});
	  
	  List<Ch11Skill> skillList = new ArrayList<>();
	  skillList.add(new Ch11Skill(1, "Springframework"));
	  skillList.add(new Ch11Skill(2, "BootStrap"));
	  skillList.add(new Ch11Skill(3, "MyBatis"));
	  model.addAttribute("skillList", skillList);
	  member.setMskill(new int[] {1,2});
	  
	  return "ch11/form3";
   }
  
   @PostMapping("/form3")
   public String handleForm3(@ModelAttribute("member") Ch11Member member) {
	   log.info(member.toString());
	   return "redirect:/ch11/content";
   }
   
   @GetMapping("/form4")
   public String form4(@ModelAttribute("member") Ch11Member member, Model model) {
	   List<String>jobList = new ArrayList<>();
	   jobList.add("학생");
	   jobList.add("개발자");
	   jobList.add("디자이너");
	   jobList.add("100수");
	   model.addAttribute("jobList", jobList);
	   member.setMjob("100수");
	   
	   List<Ch11City> cityList = new ArrayList<>();
	   cityList.add(new Ch11City(1, "서울"));
	   cityList.add(new Ch11City(2, "부산"));
	   cityList.add(new Ch11City(3, "제주"));
	   model.addAttribute("cityList", cityList);
	   member.setMcity(3);
	   return "ch11/form4";
   }
   
   @PostMapping("/form4")
   public String handleForm4(@ModelAttribute("member") Ch11Member member) {
	   log.info(member.toString());
	   return "redirect:/ch11/content";
   }
   
   @GetMapping("/form5")
   public String form5() {
	   return "ch11/form5";
   }
   @PostMapping("/form5")
   public String handleForm5() {
	   return "redirect:/ch11/content";
   }
}